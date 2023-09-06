package com.example.spring01.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String imageURL;
    private int quantity;
    private BigDecimal price;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    //Mapped es MANY TO ONE o One to One pero donde es la tabla dependiente
    @JoinColumn(name = "product_id", referencedColumnName = "id" )
    private Product product;


}
