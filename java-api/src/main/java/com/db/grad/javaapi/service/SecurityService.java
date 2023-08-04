package com.db.grad.javaapi.service;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import java.util.List;
import java.util.Optional;

@Service
public class SecurityService {
    private SecurityRepository securityRepository;

    @Autowired
    public SecurityService(SecurityRepository secureRepo) {securityRepository = secureRepo;}

    public Security addSecurity(Security security) {return securityRepository.save(security);}

    public long getNoOfSecurity()
    {
        return securityRepository.count();
    }

    public List<Security> getAllSecurity() {return securityRepository.findAll();}

    public Security updateSecurityDetails(Security securityToUpdate)
    {
        return securityRepository.save(securityToUpdate);
    }

    public boolean removeSecurity(long id)
    {
        boolean result = false;

        Optional<Security> theSecurity = securityRepository.findById(id);
        if(theSecurity.isPresent())
        {
            securityRepository.delete(theSecurity.get());
            result = true;
        }

        return  result;
    }

}
