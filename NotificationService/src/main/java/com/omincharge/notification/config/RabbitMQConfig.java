package com.omincharge.notification.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.exchange.recharge}")
    private String rechargeExchange;

    @Value("${rabbitmq.exchange.payment}")
    private String paymentExchange;

    @Value("${rabbitmq.queue.recharge-notification}")
    private String rechargeNotificationQueue;

    @Value("${rabbitmq.queue.payment-notification}")
    private String paymentNotificationQueue;

    @Value("${rabbitmq.routing-key.recharge}")
    private String rechargeRoutingKey;

    @Value("${rabbitmq.routing-key.payment}")
    private String paymentRoutingKey;

    // ── Queues ────────────────────────────────────────
    @Bean
    public Queue rechargeNotificationQueue() {
        return new Queue(rechargeNotificationQueue, true);
    }

    @Bean
    public Queue paymentNotificationQueue() {
        return new Queue(paymentNotificationQueue, true);
    }

    // ── Exchanges ─────────────────────────────────────
    @Bean
    public TopicExchange rechargeExchange() {
        return new TopicExchange(rechargeExchange);
    }

    @Bean
    public TopicExchange paymentExchange() {
        return new TopicExchange(paymentExchange);
    }

    // ── Bindings ──────────────────────────────────────
    @Bean
    public Binding rechargeBinding() {
        return BindingBuilder
                .bind(rechargeNotificationQueue())
                .to(rechargeExchange())
                .with(rechargeRoutingKey);
    }

    @Bean
    public Binding paymentBinding() {
        return BindingBuilder
                .bind(paymentNotificationQueue())
                .to(paymentExchange())
                .with(paymentRoutingKey);
    }

    // ── Message Converter ─────────────────────────────
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}