package com.stevecoder.tienda_moda_API.product.infrastructure.api;

import com.stevecoder.tienda_moda_API.common.mediator.Mediator;
import com.stevecoder.tienda_moda_API.product.application.command.delete.DeleteProductRequest;
import com.stevecoder.tienda_moda_API.product.application.query.getAll.GetAllProductsRequest;
import com.stevecoder.tienda_moda_API.product.application.query.getAll.GetAllProductsResponse;
import com.stevecoder.tienda_moda_API.product.application.query.getById.GetProductByIdRequest;
import com.stevecoder.tienda_moda_API.product.application.query.getById.GetProductByIdResponse;
import com.stevecoder.tienda_moda_API.product.infrastructure.api.dto.ProductDTO;
import com.stevecoder.tienda_moda_API.product.infrastructure.api.mapper.ProductMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController implements ProductApi {

    private final Mediator mediator;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody @Valid ProductDTO productDTO) {
        // el productDTO lo pasa a CreateProductRequest al dispatch, que a partir de la clase llama al metodo handle de la misma
        // para hacer lo que la clase requiera
        // Hago el map por pasar productDTO (un objeto completo) a otro tipo de dato
        mediator.dispatch(productMapper.mapToCreateProductRequest(productDTO));
        return ResponseEntity.created(URI.create("/api/products".concat(productDTO.getId().toString()))).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable @Valid Long id, @RequestBody ProductDTO productDTO) {

        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        // ASINCRONO
        mediator.dispatchAsync(new DeleteProductRequest(id));
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        // no hace falta realizar un map por la simplicidad de crear la request por el Id pasado
        GetProductByIdResponse response = mediator.dispatch(new GetProductByIdRequest(id));

        ProductDTO productDTO = productMapper.mapToProductDTO(response.getProduct());

        return ResponseEntity.ok(productDTO);
    }

    @GetMapping("")
    @Override
    public ResponseEntity<List<ProductDTO>> getAllProducts(@RequestParam(required = false) String pageSize) {

        GetAllProductsResponse response = mediator.dispatch(new GetAllProductsRequest());

        List<ProductDTO> productDTOList = response.getProducts().stream().map(productMapper::mapToProductDTO).toList();

        return ResponseEntity.ok(productDTOList);
    }
}
