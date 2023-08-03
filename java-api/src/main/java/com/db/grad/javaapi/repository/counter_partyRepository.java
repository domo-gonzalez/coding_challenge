package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.counter_party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Counter_partyRepository extends JpaRepository<Counter_party, Long> {

}
