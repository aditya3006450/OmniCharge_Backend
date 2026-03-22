package com.omincharge.notification.consumer;

import com.omincharge.notification.event.RechargeCompletedEvent;
import com.omincharge.notification.event.PaymentCompletedEvent;
import com.omincharge.notification.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    private static final Logger log =
        LoggerFactory.getLogger(NotificationConsumer.class);

    private final NotificationService notificationService;

    public NotificationConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.recharge-notification}")
    public void consumeRechargeNotification(RechargeCompletedEvent event) {
        log.info("Received recharge notification event for user: {}",
            event.getUserId());
        notificationService.sendRechargeNotification(event);
    }

    @RabbitListener(queues = "${rabbitmq.queue.payment-notification}")
    public void consumePaymentNotification(PaymentCompletedEvent event) {
        log.info("Received payment notification event for user: {}",
            event.getUserId());
        notificationService.sendPaymentNotification(event);
    }
}