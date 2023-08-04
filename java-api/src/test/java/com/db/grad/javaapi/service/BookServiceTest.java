package com.db.grad.javaapi.service;
//import com.db.grad.javaapi.model.Book;
//import com.db.grad.javaapi.repository.BookRepository;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository repo;

    @InjectMocks
    private BookService bookServ;

    @Test
    public  void    add_a_book_then_return_number_of_books_in_repo()
    {
        Book book = new Book();
        book.setBook_name("trading_book_6");


        Mockito.when(repo.save(book)).thenReturn(book);
        Mockito.when(repo.count()).thenReturn(6L);
        System.out.println("after mockito: "+bookServ.getNoOfBook());

        bookServ.addBook(book);
        System.out.println(book);
        System.out.println("all books: "+bookServ.getAllBook().toString());
        System.out.println(bookServ.getNoOfBook());
        long expectedResult = 6;

        // act
        long actualResult = bookServ.getNoOfBook();

        // assert
        assertEquals( expectedResult, actualResult );
    }

}
