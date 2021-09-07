package com.codegym.borrow_book.models.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int amount;
    // mappeedBy = "Trung voi ten thuoc tinh can mapped vi du o day la book ten la book"
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private Set <BorrowCode> borrowCodes;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Set < BorrowCode > getBorrowCodes() {
        return borrowCodes;
    }

    public void setBorrowCodes(Set < BorrowCode > borrowCodes) {
        this.borrowCodes = borrowCodes;
    }
}
