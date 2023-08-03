package com.db.grad.javaapi.model;


import javax.persistence.*;

@Entity
@Table(name = "book_user")
public class Book_User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long users_id;

    @GeneratedValue(strategy = GenerationType.IDENTIFY)
    private long book_id;

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {this.users_id}

    public long getBook_id() {return book_id;}
        public void setBook_id(long book_id) {this.book_id}


    @Override
    public String toString() {
        return "book_user{" +
                "users_id=" + users_id +
                ", book_id='" + book_id +
}';
    }
}

