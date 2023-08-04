package com.db.grad.javaapi.service;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepo) {bookRepository = bookRepo;}

    public Book addBook(Book book) {return bookRepository.save(book);}

    public long getNoOfBook()
    {
        return bookRepository.count();
    }

    public List<Book> getAllBook() {return bookRepository.findAll();}

    public Book updateBookDetails(Book bookToUpdate)
    {
        return bookRepository.save(bookToUpdate);
    }

    public boolean removeBook(long id)
    {
        boolean result = false;

        Optional<Book> theBook = bookRepository.findById(id);
        if(theBook.isPresent())
        {
            bookRepository.delete(theBook.get());
            result = true;
        }

        return  result;
    }


}
