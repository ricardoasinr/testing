package com.example.spring01.repository;


import com.example.spring01.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findByName(String name);

    List<Product> findByNameOrDescription(String name, String description);
    List<Product> findByNameAndDescription(String name, String description);
    List<Product> findByPriceGreaterThan(BigDecimal price); //JPA
    List<Product> findByPriceLessThan(BigDecimal price); //JPA todo es de JPA

    //Realizar consultas usando la anotación Query
    //Usar @Query para trabajar con JPQL
    //1. Con posición de parametros (JPQL)
    @Query("SELECT p from Product p where p.name =?1 or p.description =?2")
    Product findByNameOrDescriptionJPQLIndexParam(String name, String description);
    //2. Con named parameters (JPQL)
    @Query("SELECT p from Product p where p.name =:name or p.description =:description")
    Product findByNameOrDescriptionJPQLParam(String name, String description);
 ///////////////////////////////////////////////////////////////////////////////////////////
    //Realizar consultas usando la anotación Query
    //Usar @Query para trabajar con SQL NATIVO
    //1. Con posición de parametros (SQL NATIVO)
    @Query(value= "SELECT * from Products p where p.name =?1 or p.description =?2", nativeQuery = true)
    Product findByNameOrDescriptionNATIVOLIndexParam(String name, String description);
    //2. Con named parameters (SQL NATIVO)
    @Query(value = "SELECT * from Products p where p.name =:name or p.description =:description", nativeQuery = true)
    Product findByNameOrDescriptionNATIVOParam(String name, String description);

    //Realizar consultas usando @NamedQuery (@NamedQueries)
    //Existe para JPQL y SQL NATIVO
    Product findByPrice(@Param("price") BigDecimal price);
    List<Product> findAllOrderByNameDesc();

    @Query(nativeQuery = true)
    Product findByDescription(@Param("description") String description);

    List<Product> findAllOrderByNameASC();




}
