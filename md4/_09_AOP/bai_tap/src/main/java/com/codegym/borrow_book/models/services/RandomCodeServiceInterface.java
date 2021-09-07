package com.codegym.borrow_book.models.services;

import com.codegym.borrow_book.models.entity.BorrowCode;

import java.util.List;
import java.util.Set;

public interface RandomCodeServiceInterface {
    public void save (BorrowCode borrowCode);
    public List <BorrowCode> findAll();
    public BorrowCode findById(long code);
    public void remove (long code);
}
