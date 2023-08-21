package com.example.spring01.repository;

import com.example.spring01.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NativeSQLQueriesTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionNATIVOLIndexParamMethod(){
        Product product = productRepository.findByNameOrDescriptionNATIVOLIndexParam("P", "Producto 1");
        System.out.println(product.getId());
        System.out.println(product.getName());
    }

    @Test
    void findByNameOrDescriptionNATIVOParamMethod(){
        Product product = productRepository.findByNameOrDescriptionNATIVOParam("P", "Producto L");
        System.out.println(product.getId());
        System.out.println(product.getName());
    }
}
