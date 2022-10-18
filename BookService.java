public class BookService {
    package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Bookservice;
import net.javaguides.springboot.repository.BookfarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @CrossOrigin("*")
    @RestController
    public class BookServiceController {

        @Autowired
        private bookfarmRepository;

        @GetMapping
        public List<Books> getAllBooks(){
            return bookfarmRepository.findAll();
        }

        @PostMapping
        public BookService createBook(@RequestBody Book book) {
            return bookfarmRepository.save(books);
        }

        @GetMapping("{id}")
        public ResponseEntity<Book> getBookById(@PathVariable  long id){
            Book book = bookfarmRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Book not exist with id:" + id));
            return ResponseEntity.ok(book);
        }

        @PutMapping("{id}")
        public ResponseEntity<Book> updateBook(@PathVariable long id,@RequestBody Book bookDetails) {
            BookService updateBook = bookfarmRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Book not exist with id: " + id));

            updateBook.setBookName(bookDetailsDetails.getBookName());
            updateBook.setAuthorName(bookDetailsDetails.getAuthorName());
            updateBook.setBookID(bookDetailsDetails.getBookID());

            bookfarmRepository.save(updateBook);

            return ResponseEntity.ok(updateBook);
        }

        @DeleteMapping("{id}")
        public ResponseEntity<HttpStatus> deleteBook(@PathVariable long id){

            Book book = bookfarmRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Book not exist with id: " + id));

            bookfarmRepository.delete(book);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
    }
    Get All BookService REST API:
    @GetMapping
    public List<Book> getAllBook(){
        return bookfarmRepository.findAll();
    }
    Create BookService REST API:

    @PostMapping
    public BookService createBook(@RequestBody Book book) {
        return bookfarmRepository.save(book);
    }

}
