package com.pengshuai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class YpUurunServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(YpUurunServerApplication.class, args);
	}
}
