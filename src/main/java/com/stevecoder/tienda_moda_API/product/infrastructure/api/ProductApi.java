package com.stevecoder.tienda_moda_API.product.infrastructure.api;

import com.stevecoder.tienda_moda_API.product.domain.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductApi {

    public String getProduct();

    public Product getProductById(@PathVariable Long id);

    public Product createProduct(@RequestBody Product product);

    public Product updateProduct(@PathVariable Long id, @RequestBody Product product);

    public void deleteProduct(@PathVariable Long id);

}
