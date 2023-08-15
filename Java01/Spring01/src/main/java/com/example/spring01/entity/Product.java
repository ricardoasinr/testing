package com.example.spring01.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "tbl_products",
        schema = "testing",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "unique_sku",
                        columnNames = "stock_keeping_unit"
                )//,
//                @UniqueConstraint(
//                        name = "unique_sku",
//                        columnNames = "sku"
//                )

                //Auto number
                //auto = genera como quiera

        }
)
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)  //Genera automaticamente 1 2 3 4 5


    private Long id;

    @Column (nullable = false)
    private String name;
    private String description;
    @Column(name = "stock_keeping_unit" , nullable = false)
    private String sku;
    private BigDecimal price;
    private boolean active;
    private String url;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @CreationTimestamp
    private LocalDateTime updatedLast;


//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getSku() {
//        return sku;
//    }
//
//    public void setSku(String sku) {
//        this.sku = sku;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//    public boolean isActive() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }
//
//    public LocalDateTime getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(LocalDateTime createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public LocalDateTime getUpdatedLast() {
//        return updatedLast;
//    }
//
//    public void setUpdatedLast(LocalDateTime updatedLast) {
//        this.updatedLast = updatedLast;
//    }
}
