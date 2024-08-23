package org.codegym.bookdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    private int id;
    private String name;
    private String description;
    private int price;
    private Category category;


    public Book(String name, String description, int price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

}
