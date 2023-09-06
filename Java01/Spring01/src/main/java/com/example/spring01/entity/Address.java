package com.example.spring01.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Addresses")

public class Address {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

}
