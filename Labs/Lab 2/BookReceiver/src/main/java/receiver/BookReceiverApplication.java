package receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import receiver.jms.BookReceiver;

@SpringBootApplication
@EnableJms
public class BookReceiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookReceiverApplication.class, args);
    }
}
