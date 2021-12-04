package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.domain.Stock;

import reactor.core.publisher.Flux;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableScheduling
public class StockClientApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(StockClientApplication.class, args);
		
		/*
		Flux<Stock> result = WebClient.create("http://localhost:8080/stock").get().retrieve()
				.bodyToFlux(Stock.class);
		result.subscribe(s -> {
			System.out.print(LocalDateTime.now() + " : ");
			System.out.println(s);
		});
		
		*/
		//Thread.sleep(15000);
	}
}
