package com.card.backend.service.serviceImpl;

import com.card.backend.exception.CardNotFoundException;
import com.card.backend.message.RabbitMqSender;
import com.card.backend.model.entity.CardEntity;
import com.card.backend.model.converter.CardConverter;
import com.card.backend.model.dto.CardRequestDTO;
import com.card.backend.model.dto.CardResponseDTO;
import com.card.backend.model.es.CardModel;
import com.card.backend.repository.CardRepository;
import com.card.backend.repository.es.CardElasticRepository;
import com.card.backend.service.CardService;
import com.common.backend.CustomerServiceClient;
import com.common.backend.dto.CardNotification;
import com.common.backend.dto.CustomerResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final CardConverter cardConverter;
    private final CardElasticRepository cardElasticRepository;
    private final CustomerServiceClient customerServiceClient;
    private final RabbitMqSender rabbitMqSender;

    public CardServiceImpl(final CardRepository cardRepository,
                           final CardConverter cardConverter,
                           final CardElasticRepository cardElasticRepository,
                           final CustomerServiceClient customerServiceClient,
                           final RabbitMqSender rabbitMqSender) {
        this.cardRepository = cardRepository;
        this.cardConverter = cardConverter;
        this.cardElasticRepository = cardElasticRepository;
        this.customerServiceClient = customerServiceClient;
        this.rabbitMqSender = rabbitMqSender;
    }

    @Override
    public CardResponseDTO getById(String id) {
        CardEntity cardEntity = cardRepository.findById(id).orElseThrow(() -> new CardNotFoundException("Kart Bulunamadı."));
        return cardConverter.convertToDTO(cardEntity);
    }

    @Override
    public List<CardResponseDTO> getAll() {
        return cardConverter.convertToListDTO(cardRepository.findAll());
    }

    @Override
    @Transactional
    public CardResponseDTO save(CardRequestDTO cardRequestDTO) throws ClassNotFoundException {
        CardEntity cardEntity = cardConverter.convertToEntity(cardRequestDTO);
        CardModel cardModel = cardConverter.convertToModel(cardEntity);

        ResponseEntity<CustomerResponseDTO> responseDTO = customerServiceClient.getCustomerByCustomerNumber(cardRequestDTO.getCustomerNumber());
        if(!responseDTO.hasBody() || responseDTO.getBody() == null) {
            throw new ClassNotFoundException("Customer can not find!"); // değiştir
        }
        cardModel.setCustomerNameSurname(responseDTO.getBody().getFirstNameLastName());
        cardEntity = cardRepository.save(cardEntity);
        cardModel.setId(cardEntity.getId());
        cardElasticRepository.save(cardModel);

        sendMessageRabbitMq(cardEntity.getId(), responseDTO.getBody().getCustomerNumber(),responseDTO.getBody().getFirstNameLastName() + "@hotmail.com");

        return cardConverter.convertToDTO(cardEntity);
    }

    @Override
    @Transactional
    public CardResponseDTO update(String id, CardRequestDTO cardRequestDTO) {
        CardEntity cardEntity = cardRepository.findById(id).orElseThrow(() -> new CardNotFoundException("Kart Bulunamadı."));
        CardEntity card = cardConverter.convertToEntity(cardRequestDTO);
        cardEntity.setCardNumber(card.getCardNumber());
        // cardEntity.setCardType(card.getCardType());
        cardEntity.setCustomerNumber(card.getCustomerNumber());
        cardEntity.setExpirationDate(card.getExpirationDate());
        cardEntity.setSecurityCode(card.getSecurityCode());

        return cardConverter.convertToDTO(cardRepository.save(cardEntity));
    }

    private void sendMessageRabbitMq(String cardId, String customerNumber, String customerMail) {
        rabbitMqSender.send(new CardNotification(cardId, customerNumber, customerMail));
        System.out.println("Message Send Success");
    }
}
