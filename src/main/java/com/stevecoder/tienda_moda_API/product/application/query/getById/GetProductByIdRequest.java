package com.stevecoder.tienda_moda_API.product.application.query.getById;

import com.stevecoder.tienda_moda_API.common.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetProductByIdRequest implements Request<GetProductByIdResponse> {
    private Long id;
}
