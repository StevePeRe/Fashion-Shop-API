package com.stevecoder.tienda_moda_API.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Entity
@Builder
@Data
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne // muchas ordenes para un solo cliente relacionado
    @JoinColumn(name = "customer_id") // no se si le debo dar el nombre a la columna, porque de momento se llama id
    private Order order;

    private Date paymentDate;
    private PaymentMethod paymentMethod;
    private PaymentState paymentState;

}
