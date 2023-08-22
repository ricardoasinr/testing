package com.example.spring01.repository;

import com.example.spring01.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class JPQLNamedQueriesTest {
    @Autowired
    private ProductRepository productRepository;
    @Test
    void namedJPQLQueries(){

        Product product = productRepository.findByPrice(new BigDecimal(20000));
        System.out.println("----------Producto encontrado por precio------------");
        System.out.println(product.getId());
        System.out.println(product.getName());

        List<Product> productList = productRepository.findAllOrderByNameDesc();
        System.out.println("----------LISTA por JPQL------------");

        productList.forEach((p) -> {
            System.out.println("----------------------");
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getName());
        });


    }

    @Test
    void namedNATIVEQueries(){
        Product product = productRepository.findByDescription("Producto 6");
        System.out.println("----------Producto encontrado por descripción------------");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println("----------------------");

        List<Product> productList = productRepository.findAllOrderByNameASC();
        System.out.println("----------LISTA por Native SQL------------");

        productList.forEach((p) -> {
            System.out.println("----------------------");
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getName());
        });


    }




}
