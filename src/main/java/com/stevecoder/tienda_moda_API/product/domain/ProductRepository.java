package com.stevecoder.tienda_moda_API.product.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

//    Optional<Product> findById(Long id); ya esta en JPA

    void upsert(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);

//    List<ProductEntity> findByCategory(String category);


}
