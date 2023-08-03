package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.book_user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book_userRepository extends JpaRepository<Book_user, Long> {

}
