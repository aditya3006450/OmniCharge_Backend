package com.omincharge.recharge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RechargeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RechargeServiceApplication.class, args);
	}

}
