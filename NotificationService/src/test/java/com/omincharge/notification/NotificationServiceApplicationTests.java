package com.omincharge.notification;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
	    "spring.rabbitmq.host=localhost",
	    "spring.rabbitmq.port=5672",
	    "spring.rabbitmq.username=guest",
	    "spring.rabbitmq.password=guest",
	    "spring.cloud.config.enabled=false",
	    "eureka.client.enabled=false"
	})
class NotificationServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
