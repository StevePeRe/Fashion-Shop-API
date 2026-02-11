package com.stevecoder.tienda_moda_API.product.application.command.delete;

import com.stevecoder.tienda_moda_API.common.mediator.RequestHandler;
import com.stevecoder.tienda_moda_API.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // o componente. El servicio se transforma en Handle y Request
@RequiredArgsConstructor
public class DeleteProductHandler implements RequestHandler<DeleteProductRequest, Void> {

    private final ProductRepository productRepository;

    // En este caso creo el producto pasado de productDTO -> CreateProductRequest -> Product. Y se lo paso
    // al repositorio.
    @Override
    public Void handle(DeleteProductRequest request) {

        System.out.println("Eliminado producto con id: " + request.getId() + " ....");

        // Simulacion tardanza de peticion para asincronia
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productRepository.deleteById(request.getId());

        System.out.println("Eliminado producto despues del tiempo, con id: " + request.getId() + " ....");

        // las validaciones en la infraestructura
        return null;
    }

    @Override
    public Class<DeleteProductRequest> getRequestType() {
        return DeleteProductRequest.class;
    }
}
