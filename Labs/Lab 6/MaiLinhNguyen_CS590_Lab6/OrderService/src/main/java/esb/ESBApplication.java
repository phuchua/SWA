package esb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class ESBApplication implements CommandLineRunner {
	@Autowired
	RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ESBApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		restTemplate.postForLocation("http://localhost:8084/orders", new Order("331", 120.0,OrderType.International));
		restTemplate.postForLocation("http://localhost:8084/orders", new Order("334", 125.0,OrderType.Domestic));
		restTemplate.postForLocation("http://localhost:8084/orders", new Order("355", 185.0,OrderType.Domestic));
	}
}
