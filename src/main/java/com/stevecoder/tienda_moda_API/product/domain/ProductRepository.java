package com.stevecoder.tienda_moda_API.product.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

//    Optional<Product> findById(Long id); ya esta en JPA

    void upsert(Product product);

    List<Product> findByCategory(String category);

    List<Product> findByNameContainingIgnoreCase(String name);

}
