package com.stevecoder.tienda_moda_API.product.application.query.getAll;

import com.stevecoder.tienda_moda_API.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class GetAllProductsResponse {
    private List<Product> products; // devuelve la lista de productos
}
