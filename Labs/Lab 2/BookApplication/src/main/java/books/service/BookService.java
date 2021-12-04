package books.service;

import books.jms.BookSender;
import books.repository.BookRepository;
import books.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    private BookSender sender;

    public void add(Book book) {
        bookRepository.save(book);
        sender.sendMessage(book);
    }

    public void update(Book book) {
        bookRepository.save(book);
        sender.sendMessage(book);
    }

    public Book get(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public void delete(String isbn) {
        Book book = this.get(isbn);
        if (book != null) {
            bookRepository.delete(isbn);
            sender.sendMessage(book);
        }
    }

    public Collection<Book> getAll() {
        return bookRepository.getAll();
    }
}
