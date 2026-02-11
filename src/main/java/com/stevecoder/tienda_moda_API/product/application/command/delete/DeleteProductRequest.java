package com.stevecoder.tienda_moda_API.product.application.command.delete;

import com.stevecoder.tienda_moda_API.common.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteProductRequest implements Request<Void> {
    private Long id;
}
