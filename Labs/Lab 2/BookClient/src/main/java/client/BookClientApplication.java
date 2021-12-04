package client;

import domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BookClientApplication implements CommandLineRunner {
	@Autowired
	private RestOperations restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(BookClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String serverUrl = "http://localhost:8080/book";

		// add new book: 1492043451
		restTemplate.postForLocation(serverUrl,
				new Book("1492043451", "Mark Richards - Neal Ford", "Fundamentals of Software Architecture: An Engineering Approach", 46.9));
		// add new book: 0134494164
		restTemplate.postForLocation(serverUrl,
				new Book("0134494164", "Robert C. Martin", "Clean Architecture: A Craftsman's Guide to Software Structure and Design", 30.16));

		// get a book: 1492043451
		Book book = restTemplate.getForObject(serverUrl + "/{isbn}", Book.class, "1492043451");
		System.out.println("------- get book - isbn 1492043451 -------");
		System.out.println(book.toString());

		// get all books
		System.out.println("------- get all books -------");
		ResponseEntity<Book[]> response = restTemplate.getForEntity(serverUrl+"s", Book[].class);
		Book[] books = response.getBody();
		for (Book b : books) {
			System.out.println(b.toString());
		}

		// delete a book: 0134494164
		System.out.println("------- delete book - isbn 0134494164 -------");
		restTemplate.delete(serverUrl + "/{isbn}", "0134494164");

		// update a book: 1492043451
		System.out.println("------- update book - isbn 1492043451 -------");
		book.setPrice(35);
		restTemplate.put(serverUrl + "/{isbn}", book, book.getIsbn());

		// get all books again
		System.out.println("------- get all books again -------");
		response = restTemplate.getForEntity(serverUrl+"s", Book[].class);
		books = response.getBody();
		for (Book b : books) {
			System.out.println(b.toString());
		}
	}

	@Bean
	RestOperations restTemplate() {
		return new RestTemplate();
	}
}
