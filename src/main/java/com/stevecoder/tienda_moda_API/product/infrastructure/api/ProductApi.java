package com.stevecoder.tienda_moda_API.product.infrastructure.api;

import com.stevecoder.tienda_moda_API.product.infrastructure.api.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductApi {

    public ResponseEntity<Void> createProduct(@RequestBody ProductDTO productDTO);

    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO);

    public ResponseEntity<Void> deleteProduct(@PathVariable Long id);

    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id);

    public ResponseEntity<List<ProductDTO>> getAllProducts(@RequestParam(required = false) String pageSize);

}
