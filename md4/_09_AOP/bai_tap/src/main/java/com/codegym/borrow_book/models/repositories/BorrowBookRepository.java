package com.codegym.borrow_book.models.repositories;

import com.codegym.borrow_book.models.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowBookRepository extends JpaRepository< Book,Integer > {
}
