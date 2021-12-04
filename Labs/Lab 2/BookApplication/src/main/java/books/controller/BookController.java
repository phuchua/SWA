package books.controller;

import books.service.BookService;
import books.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        bookService.add(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/book/{isbn}")
    public ResponseEntity<?> updateBook(@PathVariable String isbn, @RequestBody Book book) {
        bookService.update(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @DeleteMapping("/book/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn) {
        bookService.delete(isbn);
        return new ResponseEntity<Book>(HttpStatus.OK);
    }

    @GetMapping("/book/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn) {
        Book book = bookService.get(isbn);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @GetMapping("/books")
    public Collection<Book> getAllBooks() {
        return bookService.getAll();
    }
}
