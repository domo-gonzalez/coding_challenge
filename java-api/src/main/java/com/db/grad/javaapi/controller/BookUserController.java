package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookUserController {
    private BookUserService service;

    @Autowired
    public BookUserController(BookUserService bs) {service = bs;}

    @PostMapping("/book-user")
    public BookUser createBookUser(@Valid @RequestBody BookUser bookUser) {
        return service.addBookUser(bookUser);
    }

    @GetMapping("/book-users")
    public List<BookUser> getAllBookUsers() {return service.getAllBookUsers();}


}
