package com.example.prova01.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class Product {
    private String description;
    private Integer price;
    private Date availableFrom;
}
