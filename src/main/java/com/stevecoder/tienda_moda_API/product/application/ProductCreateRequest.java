package com.stevecoder.tienda_moda_API.product.application;

import com.stevecoder.tienda_moda_API.common.mediator.Request;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.awt.*;
import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public class ProductCreateRequest implements Request<Void> {

    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private String category;
    private String size;
    private Color color;
    
}
