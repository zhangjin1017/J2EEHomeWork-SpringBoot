package com.zj.middle_book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;
    private String name;
    private String author;
    private double price;
    private String date;
    private String description;
    private String type;

    public Book(String name, String author, double price, String date, String description, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.date = date;
        this.description = description;
        this.type = type;
    }
}
