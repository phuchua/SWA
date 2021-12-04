package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Stock;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import java.time.Duration;


@RestController
public class StockServiceController {
	
	@GetMapping(value = "/stock", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Stock> getStockValue() {
		Flux<Stock> stockFlux = Flux.just(new Stock("MSFT", 290.10), 
											new Stock("MSFT", 278.17),
											new Stock("MSFT", 291.21), 
											new Stock("MSFT", 300.45), 
											new Stock("MSFT", 288.89),
											new Stock("MSFT", 255.90))
				.delayElements(Duration.ofSeconds(5));
		return stockFlux;
	}
}
