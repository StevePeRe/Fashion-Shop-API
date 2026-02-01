package com.stevecoder.tienda_moda_API.product.application.query.getById;

import com.stevecoder.tienda_moda_API.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
// Creo Response debido a que la consulta que hago me debe dar una respuesta, en este caso un producto a partir de la Id pasada como
// request
public class GetProductByIdResponse {
    private Product product; // no debo poner ProductDTO debido a que romperia las dependencias de la arquitectura hexagonal
}
