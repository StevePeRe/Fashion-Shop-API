package com.stevecoder.tienda_moda_API.product.infrastructure.database;

import com.stevecoder.tienda_moda_API.product.domain.entity.Product;
import com.stevecoder.tienda_moda_API.product.domain.port.ProductRepository;
import com.stevecoder.tienda_moda_API.product.infrastructure.database.entity.ProductEntity;
import com.stevecoder.tienda_moda_API.product.infrastructure.database.mapper.ProductEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductRepositoryImpl implements ProductRepository {

    private final List<ProductEntity> products = new ArrayList<>(); // bases de datos momentanea
    private final ProductEntityMapper productEntityMapper;

    @Override
    public void upsert(Product product) {
        ProductEntity productEntity = productEntityMapper.mapToProductEntity(product);

        products.removeIf(p -> p.getId().equals(productEntity.getId()));
        products.add(productEntity);
    }

    @Cacheable(value = "products", key = "#id")
    @Override
    public Optional<Product> findById(Long id) {
        log.info("Finding product with id {}", id);
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(productEntityMapper::mapToProduct); // le aplico el metodo por referencia al elemento encontrado
    }

    @Override
    public List<Product> findAll() {
        return products.stream()
                .map(productEntityMapper::mapToProduct)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }


//    @Override
//    public List<Product> findByCategory(String category) {
//
//        products.stream()
//                .filter(p->p.getCategory().equals(category))
//                .findFirst()
//                .map(productEntityMapper::mapToProduct);
//       ProductEntity productEntity = productEntityMapper.mapToProductEntity();
//
//        return List.of();
//    }


}
