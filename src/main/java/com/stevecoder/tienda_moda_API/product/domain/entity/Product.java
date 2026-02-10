package com.stevecoder.tienda_moda_API.product.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

//@Entity
@Builder
@Data
//@Table(name = "products")
public class Product {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private String category;
    private String size;
    private String color;

}
