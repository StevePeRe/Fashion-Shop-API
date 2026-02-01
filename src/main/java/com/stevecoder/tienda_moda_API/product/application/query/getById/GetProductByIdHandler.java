package com.stevecoder.tienda_moda_API.product.application.query.getById;

import com.stevecoder.tienda_moda_API.common.mediator.RequestHandler;
import com.stevecoder.tienda_moda_API.product.domain.Product;
import com.stevecoder.tienda_moda_API.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // o componente. El servicio se transforma en Handle y Request
@RequiredArgsConstructor
public class GetProductByIdHandler implements RequestHandler<GetProductByIdRequest, GetProductByIdResponse> {

    private final ProductRepository productRepository;

    // En este caso creo el producto pasado de productDTO -> CreateProductRequest -> Product. Y se lo paso
    // al repositorio.
    @Override
    public GetProductByIdResponse handle(GetProductByIdRequest request) {

        Product product = productRepository.findById(request.getId()).orElseThrow(() -> new IllegalArgumentException("Product not found"));

        return new GetProductByIdResponse(product);
    }

    @Override
    public Class<GetProductByIdRequest> getRequestType() {
        return GetProductByIdRequest.class;
    }
}
