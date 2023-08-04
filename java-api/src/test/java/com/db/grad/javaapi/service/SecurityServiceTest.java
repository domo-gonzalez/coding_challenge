package com.db.grad.javaapi.service;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.SecurityRepository;
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
public class SecurityServiceTest {
    @Mock
    private SecurityRepository repo;

    @InjectMocks
    private SecurityService secure;

    @Test
    public  void    add_a_security_then_return_number_of_security_in_repo()
    {
        Security security = new Security();
        security.setCoupon_percent(10.23);
        security.setBond_currency("USD");
        security.setCusip("22222222");
        security.setFace_value_mn(6969);
        security.setIsin("XS222222222");
        security.setIssuer_name("Bank of Mingo");
        security.setStatus("active");
        security.setType("corp");

        Mockito.when(repo.save(security)).thenReturn(security);
        Mockito.when(repo.count()).thenReturn(29L);
        System.out.println("after mockito: "+secure.getNoOfSecurity());

        secure.addSecurity( security );
        System.out.println(security);
        System.out.println(secure.getNoOfSecurity());
        long expectedResult = secure.getNoOfSecurity();

        // act
        long actualResult = secure.getNoOfSecurity();

        // assert
        assertEquals( expectedResult, actualResult );
    }

}
