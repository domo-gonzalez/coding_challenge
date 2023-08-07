package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.CounterPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CounterPartyController {
    private CounterPartyService service;

    @Autowired
    public CounterPartyController(CounterPartyService cp) {service = cp;}

    @PostMapping("/counter-party")
    public CounterParty createCounterParty(@Valid @RequestBody CounterParty counter) {
        return service.addCounterParty(counter);
    }

    @GetMapping("/counter-parties")
    public List<CounterParty> getAll() {return service.getAll();}

    @PutMapping("/counter-party/{id}")
    public ResponseEntity< CounterParty > updateCounterParty(@PathVariable(value = "id") Long id,
                                             @Valid @RequestBody CounterParty counterPartyDetails) throws ResourceNotFoundException {

        final CounterParty updatedCounterParty =
                service.updateCounterPartyDetails(counterPartyDetails);
        return ResponseEntity.ok(updatedCounterParty);
    }

    @DeleteMapping("/counter-party/{id}")
    public Map< String, Boolean > deleteCounteryParty(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        boolean removed = service.removeCounterParty(id);

        Map < String, Boolean > response = new HashMap<>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }


}
