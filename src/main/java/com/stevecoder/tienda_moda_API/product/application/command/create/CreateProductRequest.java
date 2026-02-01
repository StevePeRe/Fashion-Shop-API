package com.stevecoder.tienda_moda_API.product.application.command.create;

import com.stevecoder.tienda_moda_API.common.mediator.Request;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRequest implements Request<Void> {

    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private String category;
    private String size;
    private String color;

}
