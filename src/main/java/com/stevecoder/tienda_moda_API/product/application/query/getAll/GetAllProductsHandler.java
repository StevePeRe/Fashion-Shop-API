package com.stevecoder.tienda_moda_API.product.application.query.getAll;

import com.stevecoder.tienda_moda_API.common.mediator.RequestHandler;
import com.stevecoder.tienda_moda_API.product.domain.entity.Product;
import com.stevecoder.tienda_moda_API.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // o componente. El servicio se transforma en Handle y Request
@RequiredArgsConstructor
public class GetAllProductsHandler implements RequestHandler<GetAllProductsRequest, GetAllProductsResponse> {

    private final ProductRepository productRepository;

    @Override
    public GetAllProductsResponse handle(GetAllProductsRequest request) {

        // request luego se usara para saber la pagina

        List<Product> products = productRepository.findAll(); // se lo pido a domain

        return new GetAllProductsResponse(products); // se lo envio a infra
    }

    @Override
    public Class<GetAllProductsRequest> getRequestType() {
        return GetAllProductsRequest.class;
    }
}
