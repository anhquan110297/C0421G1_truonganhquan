package com.codegym.borrow_book.models.services;

import com.codegym.borrow_book.models.entity.BorrowCode;
import com.codegym.borrow_book.models.repositories.IBorrowCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RandomCodeService implements RandomCodeServiceInterface {
    @Autowired
    private IBorrowCodeRepository borrowCode;

    @Override
    public void save(BorrowCode borrowCode) {
        this.borrowCode.save(borrowCode);
    }

    @Override
    public List < BorrowCode > findAll() {
        return this.borrowCode.findAll();
    }

    @Override
    public BorrowCode findById(long code) {
        return this.borrowCode.findById(code).get();
    }

    @Override
    public void remove(long code) {
        this.borrowCode.deleteById(code);
    }
}
