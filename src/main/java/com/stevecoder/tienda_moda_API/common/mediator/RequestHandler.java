package com.stevecoder.tienda_moda_API.common.mediator;

public interface RequestHandler<T extends Request<R>, R> {

    R handle(T request);

    Class<T> getRequestType();

}
