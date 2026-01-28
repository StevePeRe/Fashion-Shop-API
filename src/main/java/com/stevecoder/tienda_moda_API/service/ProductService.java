package com.stevecoder.tienda_moda_API.service;

import com.stevecoder.tienda_moda_API.product.domain.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

}
