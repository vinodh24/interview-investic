package com.investic.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.investic.config.InvestecIntilizer;

@SpringBootApplication
@ComponentScan(basePackages = "com.investic.*")
public class InvesticApplication {
	
	private static final Logger log = LoggerFactory.getLogger(InvestecIntilizer.class);

	public static void main(String[] args) {
		SpringApplication.run(InvesticApplication.class, args);
		log.info("InvesticApplication started successfully");
	}

}
