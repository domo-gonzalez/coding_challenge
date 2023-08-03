package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepository;
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
public class UserServiceTest {
    @Mock
    private UserRepository repo;

    @InjectMocks
    private UserService cut;

    @Test
    public  void    add_a_user_return_number_of_user_in_repo_is_two()
    {
        // arrange
        User user = new User();
//        user.setId(2);
        user.setName("Rajat");
        user.setEmail("rajat@db.com");
        user.setPassword("ch33se");
        user.setRole("admin");
        Mockito.when(repo.save(user)).thenReturn(user);
        Mockito.when(repo.count()).thenReturn(2L);
        cut.addUser( user );
        System.out.println(user);
        System.out.println(cut.getNoOfUsers());
        int expectedResult = 2;

        // act
        long actualResult = cut.getNoOfUsers();

        // assert
        assertEquals( expectedResult, actualResult );
    }



}
