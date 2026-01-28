package com.stevecoder.tienda_moda_API.entity;

import com.stevecoder.tienda_moda_API.product.domain.Product;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Builder
@Data
@Table(name = "orderItems")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // muchas ordenes a una orden grande de carrito por ejemplo
    @JoinColumn(name = "order_id") // no se si le debo dar el nombre a la columna, porque de momento se llama id
    private Order order;

    @OneToOne // una orden de producto relacionado con un solo producto
    @JoinColumn(name = "product_id") // no se si le debo dar el nombre a la columna, porque de momento se llama id
    private Product product;

    private BigDecimal quantity;
    private BigDecimal pricePerUnit;

}
