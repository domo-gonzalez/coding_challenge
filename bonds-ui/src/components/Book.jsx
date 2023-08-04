import React, { useState, useEffect } from "react";
import { findBook } from "../services/BookServices";
import styles from "./Book.module.css";

export const Book = () => {
    const [book, setBook] = useState([]);

    useEffect(() => {
      findBook()
            .then(({data}) => {
            setBook(data);
            });
    }, []);
  return (
    <>
        { book.map(book => 
        <div className={styles.book}>
            <div>ID: {book.id}</div>
            <div>Name: {book.book_name} </div>
        </div>) 
        }
    </>
  )
};
