package com.notification.backend.service;


import com.common.backend.dto.CardNotification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Component;

@Component
public class NotificationDistributionService implements RabbitListenerConfigurer {

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receive(CardNotification cardNotification) {
        System.out.println("Message: " + cardNotification);
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
    }
}
