package com.example.spring01.repository;


import com.example.spring01.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findByName(String name);

    List<Product> findByNameOrDescription(String name, String description);
    List<Product> findByNameAndDescription(String name, String description);
    List<Product> findByPriceGreaterThan(BigDecimal price); //JPA
    List<Product> findByPriceLessThan(BigDecimal price); //JPA todo es de JPA

}
