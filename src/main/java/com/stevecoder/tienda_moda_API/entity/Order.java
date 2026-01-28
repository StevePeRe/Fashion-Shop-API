package com.stevecoder.tienda_moda_API.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Builder
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // muchas ordenes para un solo cliente relacionado
    @JoinColumn(name = "customer_id") // no se si le debo dar el nombre a la columna, porque de momento se llama id
    private Customer customer;

    private Date date;
    private OrderState orderState; // estado de la compra, crear un enum aparte
    private BigDecimal total;

}
