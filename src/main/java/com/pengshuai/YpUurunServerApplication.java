package com.pengshuai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@EnableTransactionManagement
public class YpUurunServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(YpUurunServerApplication.class, args);
	}
}
