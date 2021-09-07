package com.codegym.borrow_book.models.repositories;

import com.codegym.borrow_book.models.entity.BorrowCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowCodeRepository extends JpaRepository<BorrowCode, Long > {
}
