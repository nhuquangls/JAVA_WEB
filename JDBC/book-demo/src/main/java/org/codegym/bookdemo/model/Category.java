package org.codegym.bookdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    private int id;
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
