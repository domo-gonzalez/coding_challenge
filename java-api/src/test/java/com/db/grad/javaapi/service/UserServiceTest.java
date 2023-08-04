package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepository;
import org.junit.Ignore;
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
import java.util.Optional;

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

    @Ignore
    @Test
    public  void    update_user_that_exists_returns_user_id()
    {
        // arrange
        User theUser = new User();
        theUser.setName("Domo");
        theUser.setEmail("domo@db.com");
        theUser.setPassword("nacho");
        theUser.setRole("analyst");
        cut.addUser( theUser );
        theUser = new User();
        theUser.setName("Tyrone");
        theUser.setEmail("tyrone@db.com");
        theUser.setPassword("mochi");
        theUser.setRole("VP");
        Mockito.when(repo.save(theUser)).thenReturn(theUser);
        User expectedUser = cut.addUser( theUser );
        User userToUpdate = theUser;
        String dogToFind = "Tyrone";
        theUser = new User();
        theUser.setName("Christine");
        theUser.setEmail("christine@db.com");
        theUser.setPassword("tortilla");
        theUser.setRole("Associate");
        cut.addUser( theUser );
        Mockito.when(repo.save(userToUpdate)).thenReturn(userToUpdate);

        // act
        userToUpdate.setName("Charlie");
        User actualUser = cut.updateUserDetails( userToUpdate );

        // assert
        Assertions.assertEquals( expectedUser, actualUser );
    }

    @Test
    public  void    find_user_by_valid_id_returns_one_user()
    {
        // arrange
        User theUser= new User();
        theUser.setName("Christine");
        theUser.setEmail("christine@db.com");
        theUser.setPassword("tortilla");
        theUser.setRole("Associate");
        cut.addUser( theUser );
        theUser = new User();
        theUser = new User();
        theUser.setName("Tyrone");
        theUser.setEmail("tyrone@db.com");
        theUser.setPassword("mochi");
        theUser.setRole("VP");
        Mockito.when(repo.save(theUser)).thenReturn(theUser);
        User addedUser = cut.addUser( theUser );
        User expectedUser = theUser;
        theUser = new User();
        theUser.setName("Domo");
        theUser.setEmail("domo@db.com");
        theUser.setPassword("nacho");
        theUser.setRole("analyst");
        cut.addUser( addedUser );

        User jpaUser= addedUser;
        Optional<User> opt = Optional.of(addedUser);
        Mockito.when(repo.findById(addedUser.getId())).thenReturn(opt);

        // act
        User actualResult = cut.getUserById( addedUser.getId() );

        // assert
        Assertions.assertEquals( expectedUser.getId(), actualResult.getId() );
        Assertions.assertEquals( expectedUser.getName(), actualResult.getName() );
    }


}
