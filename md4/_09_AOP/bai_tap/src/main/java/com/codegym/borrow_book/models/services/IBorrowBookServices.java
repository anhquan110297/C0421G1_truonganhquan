package com.codegym.borrow_book.models.services;

import com.codegym.borrow_book.models.entity.Book;

import java.util.List;

public interface IBorrowBookServices {
    public List<Book> findAll();
    public void save (Book book);
    public Book findById (int id);
}
