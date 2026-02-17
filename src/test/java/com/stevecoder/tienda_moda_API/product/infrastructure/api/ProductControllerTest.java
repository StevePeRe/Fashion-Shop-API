package com.stevecoder.tienda_moda_API.product.infrastructure.api;

import com.stevecoder.tienda_moda_API.common.mediator.Mediator;
import com.stevecoder.tienda_moda_API.product.application.query.getAll.GetAllProductsRequest;
import com.stevecoder.tienda_moda_API.product.application.query.getAll.GetAllProductsResponse;
import com.stevecoder.tienda_moda_API.product.domain.entity.Product;
import com.stevecoder.tienda_moda_API.product.infrastructure.api.dto.ProductDTO;
import com.stevecoder.tienda_moda_API.product.infrastructure.api.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // permite que los mocks esten abiertos y preparados. ahorra codigo
class ProductControllerTest {

    @Mock // Simula
    private Mediator mediator;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductController productController;

    @Test // para que pueda ser testeable y probable
    public void getAllProducts() {

        GetAllProductsResponse getAllProductsResponse = new GetAllProductsResponse(List.of(
                Product.builder().id(1L).build(),
                Product.builder().id(2L).build()
        ));

        when(mediator.dispatch(new GetAllProductsRequest())).thenReturn(getAllProductsResponse);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);

        when(productMapper.mapToProductDTO(any(Product.class))).thenReturn(productDTO);

        ResponseEntity<List<ProductDTO>> response = productController.getAllProducts("5");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        List<ProductDTO> products = response.getBody();
        assertEquals(2, products.size());

    }

}