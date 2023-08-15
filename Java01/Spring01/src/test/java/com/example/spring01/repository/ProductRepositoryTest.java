package com.example.spring01.repository;

import com.example.spring01.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class ProductRepositoryTest {
    //Debemos inyectar la interface que hereda los métodos
    //del JPA Repository

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        //Crear el producto

        Product product = new Product ();
        product.setName("Producto 1");
        product.setDescription("Producto 1");
        product.setPrice(new BigDecimal( 2000));
        product.setActive(true);
        product.setSku("2030FDS");
        product.setUrl("https://www.shutterstock.com/shutterstock/photos/78776677/display_1500/stock-photo-good-price-sticker-78776677.jpg");
        //Mostrar lo que se guardó
        Product saveObject = productRepository.save(product);
        //Guardar
        System.out.println("Id del producto: "+saveObject.getId());
        System.out.println("Nombre del producto: "+saveObject.getName());
        System.out.println(saveObject.toString());

    }

    @Test
    void updateUsingSaveMethod() {
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        product.setName("Producto Nro1");
        Product saveObject = productRepository.save(product);
        System.out.println("UPDATE: Nombre del producto: "+saveObject.getName());
        productRepository.save(product);
    }
}