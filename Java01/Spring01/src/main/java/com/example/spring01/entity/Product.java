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
//@NamedQuery(
//        name = "Product.findByPrice",
//        query = "SELECT p FROM Product p where p.price =:price"
//)


@NamedQueries({
        @NamedQuery(
                name = "Product.findByPrice",
                query = "SELECT p FROM Product p where p.price =:price"

        ),

        @NamedQuery(
                name = "Product.findAllOrderByNameDesc",
                query = "SELECT p FROM Product p ORDER BY p.name DESC"
        ),


})

@NamedNativeQueries({

        @NamedNativeQuery(
                name = "Product.findByDescription",
                query = "SELECT *  FROM tbl_products  p where p.description =:description",
                resultClass = Product.class
        ),

        @NamedNativeQuery(
                name = "Product.findAllOrderByNameASC",
                query = "SELECT * FROM tbl_products p ORDER BY p.name ASC",
                resultClass = Product.class
        ),


})
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
