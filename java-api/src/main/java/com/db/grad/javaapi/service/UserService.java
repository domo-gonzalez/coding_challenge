package com.db.grad.javaapi.service;


import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import java.util.List;
import java.util.Optional;

@Service
public class UserService{
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepo) {userRepository = userRepo;}

    public User addUser(User user) {return userRepository.save(user);}

    public long getNoOfUsers()
    {
        return userRepository.count();
    }

    public List<User> getAllUsers() {return userRepository.findAll();}

    public User updateUserDetails(User userToUpdate)
    {
        return userRepository.save( userToUpdate );
    }

    public boolean removeUser(long id)
    {
        boolean result = false;

        Optional<User> theUser = userRepository.findById(id);
        if(theUser.isPresent())
        {
            userRepository.delete(theUser.get());
            result = true;
        }

        return  result;
    }


}
