package com.db.grad.javaapi.service;


import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.CounterPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CounterPartyService {
    private CounterPartyRepository counterPartyRepository;

    @Autowired
    public CounterPartyService(CounterPartyRepository counterPartyRepo) {counterPartyRepository =
            counterPartyRepo;}

    public CounterParty addCounterParty(CounterParty counter) {return counterPartyRepository.save(counter);}

    public long getNoOfCounterParties() {return counterPartyRepository.count();}

    public List<CounterParty> getAll() {return counterPartyRepository.findAll();}

    public CounterParty updateCounterPartyDetails(CounterParty counterPartyToUpdate)
    {
        return counterPartyRepository.save( counterPartyToUpdate );
    }

    public boolean removeCounterParty(long id)
    {
        boolean result = false;

        Optional<CounterParty> theCounterParty = counterPartyRepository.findById(id);
        if(theCounterParty.isPresent())
        {
            counterPartyRepository.delete(theCounterParty.get());
            result = true;
        }

        return  result;
    }



}
