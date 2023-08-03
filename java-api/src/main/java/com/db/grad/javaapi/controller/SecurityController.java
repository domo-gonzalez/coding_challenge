package com.db.grad.javaapi.controller;
import com.db.grad.javaapi.exception.ResourceNotFoundException;
//import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.model.Security;
//import com.db.grad.javaapi.model.User;
//import com.db.grad.javaapi.service.DogHandler;
import com.db.grad.javaapi.service.SecurityService;
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

public class SecurityController {
    private SecurityService service;

    @Autowired
    public SecurityController(SecurityService ss)
    {
        service = ss;
    }

    @PostMapping("/security")
    public Security createSecurity(@Valid @RequestBody Security security) {
        return service.addSecurity(security);
    }

    @GetMapping("/Security")
    public List<Security> getAllSecurity() {return service.getAllSecurity();}

    @PutMapping("/security/{id}")
    public ResponseEntity< Security > updateSecurity(@PathVariable(value = "id") Long id,
                                             @Valid @RequestBody Security securityDetails) throws ResourceNotFoundException {

        final Security updatedSecurity = service.updateSecurityDetails(securityDetails);
        return ResponseEntity.ok(updatedSecurity);
    }

    @DeleteMapping("/security/{id}")
    public Map< String, Boolean > deleteSecurity(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        boolean removed = service.removeSecurity(id);

        Map < String, Boolean > response = new HashMap<>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}
