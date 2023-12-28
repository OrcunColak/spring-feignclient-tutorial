package com.colak.springfeignclienttutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringFeignClientTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFeignClientTutorialApplication.class, args);
	}

}
