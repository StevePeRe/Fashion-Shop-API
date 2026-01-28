package com.stevecoder.tienda_moda_API.product.infrastructure.api;

import com.stevecoder.tienda_moda_API.common.mediator.Mediator;
import com.stevecoder.tienda_moda_API.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final Mediator mediator;

    @GetMapping
    public String getProduct() {
        return "Retorno todos los productos";
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return null;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        
    }
}
