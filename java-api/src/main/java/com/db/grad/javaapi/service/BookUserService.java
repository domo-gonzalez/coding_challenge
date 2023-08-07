package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.BookUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookUserService {
    BookUserRepository bookUserRepository;

    @Autowired
    public BookUserService(BookUserRepository bookUserRepo) {bookUserRepository = bookUserRepo;}

    public BookUser addBookUser(BookUser bookUser) {return bookUserRepository.save(bookUser);}

    public long getNoOfBookUsers()
    {
        return bookUserRepository.count();
    }

    public List<BookUser> getAllBookUsers() {return bookUserRepository.findAll();}
}
