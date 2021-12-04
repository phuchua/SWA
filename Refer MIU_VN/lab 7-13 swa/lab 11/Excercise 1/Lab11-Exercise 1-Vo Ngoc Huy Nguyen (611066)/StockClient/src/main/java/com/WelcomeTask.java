package com;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.domain.Stock;

import reactor.core.publisher.Flux;

@Component
public class WelcomeTask {

	@Scheduled(fixedRate = 5000)
	public void welcome() {
		Flux<Stock> result = WebClient.create("http://localhost:8080/stock").get().retrieve().bodyToFlux(Stock.class);
		result.subscribe(s -> {
			System.out.print(LocalDateTime.now() + " : ");
			System.out.println(s);
		});

	}
}
