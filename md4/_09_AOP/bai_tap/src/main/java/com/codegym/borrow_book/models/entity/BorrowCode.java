package com.codegym.borrow_book.models.entity;

import javax.persistence.*;

@Entity
@Table
public class BorrowCode {
    @Id
    private long code;
    @ManyToOne(targetEntity = Book.class)
    @JoinColumn (referencedColumnName = "id",name = "book")
    private Book book;

    public BorrowCode() {
    }

    public BorrowCode(long code, Book book) {
        this.code = code;
        this.book = book;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
