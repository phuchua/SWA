package books.jms;

import books.domain.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BookSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(Book book) {
        ObjectMapper objectMapper = new ObjectMapper();
        String bookAsString = "";
        try{
            //convert book to JSON string
            bookAsString = objectMapper.writeValueAsString(book);
            System.out.println("Sending a JMS message:" + bookAsString);
            jmsTemplate.convertAndSend("BookQueue", bookAsString);
        } catch (IOException e) {
            System.out.println("JMS receiver: Cannot convert : " + bookAsString + " to a Book object");
        }
    }
}
