package com.db.grad.javaapi.controller;
import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class BookController {

        private BookService service;

        @Autowired
        public BookController(BookService bs)
        {
            service = bs;
        }

        @PostMapping("/book")
        public Book createBook(@Valid @RequestBody Book book) {
            return service.addBook(book);
        }

        @GetMapping("/book")
        public List<Book> getAllBook() {return service.getAllBook();}

        @PutMapping("/book/{id}")
        public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Long id,
                                                         @Valid @RequestBody Book bookDetails) throws ResourceNotFoundException {

            final Book updatedBook = service.updateBookDetails(bookDetails);
            return ResponseEntity.ok(updatedBook);
        }

        @DeleteMapping("/book/{id}")
        public Map< String, Boolean > deleteBook(@PathVariable(value = "id") Long id)
                throws ResourceNotFoundException {
            boolean removed = service.removeBook(id);

            Map < String, Boolean > response = new HashMap<>();
            if( removed )
                response.put("deleted", Boolean.TRUE);
            else
                response.put("deleted", Boolean.FALSE);

            return response;
        }

}
