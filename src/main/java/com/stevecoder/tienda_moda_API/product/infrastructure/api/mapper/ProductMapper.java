package com.stevecoder.tienda_moda_API.product.infrastructure.api.mapper;

import com.stevecoder.tienda_moda_API.product.application.command.create.CreateProductRequest;
import com.stevecoder.tienda_moda_API.product.domain.Product;
import com.stevecoder.tienda_moda_API.product.infrastructure.api.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.ERROR)
// componentModel de spring para que al arrancar se cree un Bean para inyectar la implementacion que va a generar la clase
// en tiempo de compilacion
public interface ProductMapper {

    // Transforma el productDTO a CreateProductRequest
    CreateProductRequest mapToCreateProductRequest(ProductDTO productDTO);

    ProductDTO mapToProductDTO(Product product);
}
