package com.stevecoder.tienda_moda_API.product.infrastructure.api;

import com.stevecoder.tienda_moda_API.common.mediator.Mediator;
import com.stevecoder.tienda_moda_API.product.application.command.delete.DeleteProductRequest;
import com.stevecoder.tienda_moda_API.product.application.query.getAll.GetAllProductsRequest;
import com.stevecoder.tienda_moda_API.product.application.query.getAll.GetAllProductsResponse;
import com.stevecoder.tienda_moda_API.product.application.query.getById.GetProductByIdRequest;
import com.stevecoder.tienda_moda_API.product.application.query.getById.GetProductByIdResponse;
import com.stevecoder.tienda_moda_API.product.infrastructure.api.dto.ProductDTO;
import com.stevecoder.tienda_moda_API.product.infrastructure.api.mapper.ProductMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product", description = "Product API operations") // tag para swagger
@RequiredArgsConstructor
@Slf4j
public class ProductController implements ProductApi {

    private final Mediator mediator;
    private final ProductMapper productMapper;

    @Operation(summary = "Get all products", description = "Get all products")
    @GetMapping("")
    @Override
    public ResponseEntity<List<ProductDTO>> getAllProducts(@RequestParam(required = false) String pageSize) {

        GetAllProductsResponse response = mediator.dispatch(new GetAllProductsRequest());

        List<ProductDTO> productDTOList = response.getProducts().stream().map(productMapper::mapToProductDTO).toList();

        return ResponseEntity.ok(productDTOList);
    }

    @Operation(summary = "Get product by id", description = "Get product by id")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        // no hace falta realizar un map por la simplicidad de crear la request por el Id pasado
        GetProductByIdResponse response = mediator.dispatch(new GetProductByIdRequest(id));

        ProductDTO productDTO = productMapper.mapToProductDTO(response.getProduct());

        return ResponseEntity.ok(productDTO);
    }

    @Operation(summary = "Save product", description = "Save product")
    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody @Valid ProductDTO productDTO) {
        // el productDTO lo pasa a CreateProductRequest al dispatch, que a partir de la clase llama al metodo handle de la misma
        // para hacer lo que la clase requiera
        // Hago el map por pasar productDTO (un objeto completo) a otro tipo de dato
        mediator.dispatch(productMapper.mapToCreateProductRequest(productDTO));
        return ResponseEntity.created(URI.create("/api/products".concat(productDTO.getId().toString()))).build();
    }

    @Operation(summary = "Update product", description = "Update product")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable @Valid Long id, @RequestBody ProductDTO productDTO) {

        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Delete product", description = "Delete product")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        // ASINCRONO
        mediator.dispatchAsync(new DeleteProductRequest(id));
        return ResponseEntity.accepted().build();
    }
}
