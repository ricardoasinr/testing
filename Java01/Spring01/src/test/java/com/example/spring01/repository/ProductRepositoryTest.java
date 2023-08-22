package com.example.spring01.repository;

import com.example.spring01.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    //Debemos inyectar la interface que hereda los métodos
    //del JPA Repository

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethodMult() {
        //Crear el producto

        Product product = new Product ();
        product.setName("Producto 6");
        product.setDescription("Producto 6");
        product.setPrice(new BigDecimal( 2000));
        product.setActive(true);
        product.setSku("904LKLDF");
        product.setUrl("https://www.shutterstock.com/shutterstock/photos/78776677/display_1500/stock-photo-good-price-sticker-78776677.jpg");

        Product product5 = new Product ();
        product5.setName("Producto 5");
        product5.setDescription("Producto 2");
        product5.setPrice(new BigDecimal( 2000));
        product5.setActive(true);
        product5.setSku("000LLL2");
        product5.setUrl("https://www.shutterstock.com/shutterstock/photos/78776677/display_1500/stock-photo-good-price-sticker-78776677.jpg");


        productRepository.saveAll(
                List.of(product5, product));

    }

    @Test
    void saveMethodOnlyOne() {
        //Crear el producto

        Product product = new Product ();
        product.setName("Producto 3J");
        product.setDescription("Producto l");
        product.setPrice(new BigDecimal( 20000));
        product.setActive(true);
        product.setSku("02");
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

    @Test
    void findAllMethod() {
        List<Product> productList = productRepository.findAll();
        productList.forEach((p) -> {
            System.out.println("Nombre del producto: "+p.getName());
        });
    }

    @Test
    void deleteById(){
        productRepository.deleteById(11L);
    }

    @Test
    void deleteMethod(){
        //Encontramos
        Product product = productRepository.findById(3L).get();

        //Eliminamos
        productRepository.delete(product);

    }

    @Test
    void deleteAllMethod(){
        //Encontramos
        Product product1 = productRepository.findById(14L).get();
        Product product2 = productRepository.findById(18L).get();

        //Eliminamos
        productRepository.deleteAll(List.of(product1, product2));

    }


}