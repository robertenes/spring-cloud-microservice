package com.card.backend.message;

import com.common.backend.dto.CardNotification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMqSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    public void send(CardNotification cardNotification) {
        rabbitTemplate.convertAndSend(exchange, routingkey, cardNotification);
    }
}