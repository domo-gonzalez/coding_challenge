package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "select * from users u where u.name like %:name%")
    List<User> findByName(@Param("name")String name);

}
