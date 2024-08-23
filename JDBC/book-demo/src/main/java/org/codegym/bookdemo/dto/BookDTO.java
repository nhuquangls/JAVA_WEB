package org.codegym.bookdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDTO {
    private int id;
    private String name;
    private String description;
    private int price;
    private String category_name;

}
