package com.coppeltestmg.coppeltest2;

import com.coppeltestmg.coppeltest2.model.Cuentas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class CoppelTest2Application {


	public static void main(String[] args) {
		SpringApplication.run(CoppelTest2Application.class, args);
	}



}
