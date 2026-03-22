package com.omincharge.payment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
	    "spring.datasource.url=jdbc:postgresql://localhost:5432/omincharge",
	    "spring.datasource.username=aman",
	    "spring.datasource.password=tiger",
	    "spring.datasource.driver-class-name=org.postgresql.Driver",
	    "spring.jpa.hibernate.ddl-auto=update",
	    "spring.cloud.config.enabled=false",
	    "eureka.client.enabled=false"
	})
class PaymentServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
