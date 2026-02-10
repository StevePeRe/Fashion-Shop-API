package com.stevecoder.tienda_moda_API.product.application.command.create;

import com.stevecoder.tienda_moda_API.common.mediator.RequestHandler;
import com.stevecoder.tienda_moda_API.product.domain.entity.Product;
import com.stevecoder.tienda_moda_API.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // o componente. El servicio se transforma en Handle y Request
@RequiredArgsConstructor
public class CreateProductHandler implements RequestHandler<CreateProductRequest, Void> {

    private final ProductRepository productRepository;

    // En este caso creo el producto pasado de productDTO -> CreateProductRequest -> Product. Y se lo paso
    // al repositorio.
    @Override
    public Void handle(CreateProductRequest request) {

        // podria crear un mapper para evitar hacer la build, lo hace mas corto
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
    public Class<CreateProductRequest> getRequestType() {
        return CreateProductRequest.class;
    }
}
