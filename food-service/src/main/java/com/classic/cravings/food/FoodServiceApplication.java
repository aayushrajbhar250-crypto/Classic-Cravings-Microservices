package com.classic.cravings.food;

import com.classic.cravings.food.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class FoodServiceApplication implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {

	}

//	@Autowired
//	private TestConfig testConfig;

	public static void main(String[] args) {
		SpringApplication.run(FoodServiceApplication.class, args);
	}

}
