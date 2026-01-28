package com.stevecoder.tienda_moda_API.product.application;

import com.stevecoder.tienda_moda_API.common.mediator.RequestHandler;
import com.stevecoder.tienda_moda_API.product.domain.Product;
import com.stevecoder.tienda_moda_API.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // o componente
@RequiredArgsConstructor
public class ProductCreateHandler implements RequestHandler<ProductCreateRequest, Void> {

    private final ProductRepository productRepository;

    @Override
    public Void handle(ProductCreateRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .id(request.getId())
                .description(request.getDescription())
                .price(request.getPrice())
                .stockQuantity(request.getStockQuantity())
                .category(request.getCategory())
                .size(request.getSize())
                .color(request.getColor())
                .build();

        productRepository.upsert(product);
        // las validaciones en la infraestructura
        return null;
    }

    @Override
    public Class<ProductCreateRequest> getRequestType() {
        return ProductCreateRequest.class;
    }
}
