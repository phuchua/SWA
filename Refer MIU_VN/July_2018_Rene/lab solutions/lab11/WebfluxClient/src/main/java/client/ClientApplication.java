package client;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class ClientApplication {
		
	public static void main(String[] args) throws InterruptedException{
		 Flux<Stock> result = WebClient.create("http://localhost:8080/stock")
		  .get()
		  .retrieve()
          .bodyToFlux(Stock.class);
		result.subscribe(s->printStock(s));

		Thread.sleep(60000);
	}
	
	public static void printStock(Stock stock) {
		System.out.print(LocalDateTime.now()+" : ");
	    System.out.println(stock);
	}
}
