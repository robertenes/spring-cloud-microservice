package com.card.backend.model.converter;

import com.card.backend.model.entity.CardEntity;
import com.card.backend.model.dto.CardRequestDTO;
import com.card.backend.model.dto.CardResponseDTO;
import com.card.backend.model.entity.CardType;
import com.card.backend.model.es.CardModel;
import lombok.NoArgsConstructor;
import org.modelmapper.*;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CardConverter extends AbstractConverter<String, Integer> {

    private final ModelMapper modelMapper;

    public  CardConverter(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Converter<CardRequestDTO, CardType> convertEnumToEntityConfig = context -> CardType.getCardTypeByString(context.getSource().getCardType());

        Converter<CardEntity, String> convertBooleanToEntity = context -> context.getSource().isActive() ? "true" : "false";


        PropertyMap<CardRequestDTO, CardEntity> candidateMapping = new PropertyMap<>() {
            protected void configure() {
                using(convertEnumToEntityConfig).map(source).setCardType(null);
            }
        };

        PropertyMap<CardEntity, CardModel> candidateMapping1 = new PropertyMap<>() {
            protected void configure() {
                using(convertBooleanToEntity).map(source).setActive(null);
                // map(source.getCustomerNumber()).setGetCustomerNumber(null); Farklı alanların maplenmesi isteniyorsa bu şekilde yapılmalı
            }
        };


        TypeMap<CardRequestDTO, CardEntity> typeMap = modelMapper.getTypeMap(CardRequestDTO.class, CardEntity.class);
        if (typeMap == null) { // if not  already added
            modelMapper.addMappings(candidateMapping);
        }
        TypeMap<CardEntity, CardModel> typeMap1 = modelMapper.getTypeMap(CardEntity.class, CardModel.class);
        if (typeMap1 == null) { // if not  already added
            modelMapper.addMappings(candidateMapping1);
        }
    }

    public CardModel convertToModel(CardEntity cardEntity) {
        return modelMapper.map(cardEntity, CardModel.class);
    }

    public CardResponseDTO convertToDTO(CardEntity cardEntity) {
        return modelMapper.map(cardEntity, CardResponseDTO.class);
    }

    public CardEntity convertToEntity(CardRequestDTO cardRequestDTO) {
        return modelMapper.map(cardRequestDTO, CardEntity.class);
    }

    public List<CardResponseDTO> convertToListDTO(List<CardEntity> cardEntityList) {

        return cardEntityList.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private CardResponseDTO convert(CardEntity cardEntity) {
        return modelMapper.map(cardEntity, CardResponseDTO.class);
    }

    @Override
    protected Integer convert(String source) {
        return CardType.valueOf(source).ordinal();
    }

}
