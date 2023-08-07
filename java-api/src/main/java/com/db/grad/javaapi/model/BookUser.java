package com.db.grad.javaapi.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book_user")
public class BookUser implements Serializable {
    @Id
    @Column(name = "users_id", nullable = false)
    private long usersId;
    
    @Column(name = "book_id", nullable = false)
    private long bookId;

    public long getUsersId() {
        return usersId;
    }

    public long getBookId() {
        return bookId;
    }

    @Override
    public String toString() {
        return "BookUser{" +
                "usersId=" + usersId +
                ", bookId=" + bookId +
                '}';
    }
}
