package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.DogHandler;
import com.db.grad.javaapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService us)
    {
        service = us;
    }

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user) {
        return service.addUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {return service.getAllUsers();}

    @PutMapping("/users/{id}")
    public ResponseEntity< User > updateUser(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody User userDetails) throws ResourceNotFoundException {

        final User updatedUsers = service.updateUserDetails(userDetails);
        return ResponseEntity.ok(updatedUsers);
    }

    @DeleteMapping("/users/{id}")
    public Map< String, Boolean > deleteUser(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        boolean removed = service.removeUser(id);

        Map < String, Boolean > response = new HashMap<>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }

}
