package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@ComponentScan("com")
@SpringBootApplication

public class StockServiceApplication  {

	public static void main(String[] args) {
		SpringApplication.run(StockServiceApplication.class, args);
	}

	
}
