package receiver.jms;

import receiver.domain.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class BookReceiver {

    @JmsListener(destination = "BookQueue")
    public void receiveMessage(String bookAsString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println("Received message: " + bookAsString);
            Book book = objectMapper.readValue(bookAsString, Book.class);
            System.out.println(String.format("JMS receiver received message:\nISBN: %s\nAuthor: %s\nTitle: %s\nPrice: %f",
                    book.getIsbn(), book.getAuthor(), book.getTitle(), book.getPrice()));
        } catch (IOException e) {
            System.out.println("JMS receiver: Cannot convert : " + bookAsString+" to a Book object");
        }
    }
}
