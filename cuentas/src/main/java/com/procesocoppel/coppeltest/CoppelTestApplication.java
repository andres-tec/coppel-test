package com.procesocoppel.coppeltest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class CoppelTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoppelTestApplication.class, args);
	}

}
