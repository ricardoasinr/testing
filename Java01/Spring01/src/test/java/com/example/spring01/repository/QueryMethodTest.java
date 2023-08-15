package com.example.spring01.repository;

import com.example.spring01.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

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

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> productList = productRepository.findByNameOrDescription("Producto Nro1", "Producto 2");
        productList.forEach((p) -> {
            System.out.println("Nombre del producto: "+p.getName());
        });
    }

    @Test
    void findByNameANDDescriptionMethod() {
        List<Product> productList = productRepository.findByNameAndDescription("Producto Nro1", "Producto 1");
        productList.forEach((p) -> {
            System.out.println("Nombre del producto: "+p.getName());
        });

    }

    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> productList = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        productList.forEach((p) -> {
            System.out.println("Nombre del producto: "+p.getName());
        });

    }


}
