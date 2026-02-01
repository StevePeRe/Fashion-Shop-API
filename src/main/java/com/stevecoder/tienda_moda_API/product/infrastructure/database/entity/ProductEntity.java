package com.stevecoder.tienda_moda_API.product.infrastructure.database.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductEntity {

    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private String category;
    private String size;
    private String color;

}
