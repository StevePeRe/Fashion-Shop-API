package com.stevecoder.tienda_moda_API.product.application.scheduling;

import com.stevecoder.tienda_moda_API.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class FixProductsPriceSchedule {

    private final ProductRepository productRepository;

    @Scheduled(fixedRate = 60000)
    public void fixProductsPrice() {

        log.info("Arreglando precio de productos");

        productRepository.findAll().forEach(product -> {
            product.setPrice(product.getPrice().multiply(BigDecimal.valueOf(1.1)));
            productRepository.upsert(product);
        });

        log.info("Acabando de arreglar precio de productos");

    }

}
