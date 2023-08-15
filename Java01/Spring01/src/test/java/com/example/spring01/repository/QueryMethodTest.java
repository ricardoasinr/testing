package com.example.spring01.repository;

import com.example.spring01.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest 
public class QueryMethodTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("Producto 3");
        System.out.println("Id del producto: "+product.getId());
        System.out.println("Nombre del producto: "+product.getName());

    }
}
