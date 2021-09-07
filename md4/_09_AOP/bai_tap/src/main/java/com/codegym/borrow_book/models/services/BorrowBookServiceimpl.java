package com.codegym.borrow_book.models.services;

import com.codegym.borrow_book.models.entity.Book;
import com.codegym.borrow_book.models.repositories.BorrowBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowBookServiceimpl implements IBorrowBookServices {
    @Autowired
    private BorrowBookRepository borrowBookRepository;

    @Override
    public List < Book > findAll() {
        return this.borrowBookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        this.borrowBookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return this.borrowBookRepository.findById(id).orElse(new Book());
    }
}
