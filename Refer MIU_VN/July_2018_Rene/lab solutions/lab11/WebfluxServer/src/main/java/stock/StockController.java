package stock;

import java.time.Duration;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class StockController {
	
	@GetMapping(value="/stock", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Stock> getStockValue() {
			Flux<Stock> customerFlux = Flux.just(new Stock("ASML", 155.75),
					new Stock("ASML", 155.85),
					new Stock("ASML", 155.95),
					new Stock("ASML", 156.25),
					new Stock("ASML", 156.35),
					new Stock("ASML", 156.45),
					new Stock("ASML", 156.55),
					new Stock("ASML", 156.75)
			  ).delayElements(Duration.ofSeconds(5));
		return customerFlux;	
    }	
}
