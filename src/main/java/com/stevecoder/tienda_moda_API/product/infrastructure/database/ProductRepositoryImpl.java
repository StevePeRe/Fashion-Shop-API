package com.stevecoder.tienda_moda_API.product.infrastructure.database;

import com.stevecoder.tienda_moda_API.product.domain.Product;
import com.stevecoder.tienda_moda_API.product.domain.ProductRepository;
import com.stevecoder.tienda_moda_API.product.infrastructure.database.entity.ProductEntity;
import com.stevecoder.tienda_moda_API.product.infrastructure.database.mapper.ProductEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final List<ProductEntity> products = new ArrayList<>(); // bases de datos momentanea
    private final ProductEntityMapper productEntityMapper;

    @Override
    public void upsert(Product product) {
        products.add(productEntityMapper.mapToProductEntity(product));
    }

    @Override
    public Optional<Product> findById(Long id) {
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
