package com.example.spring01.repository;

import com.example.spring01.entity.Address;
import com.example.spring01.entity.Order;
import com.example.spring01.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneUnidirectionalMappingTest {
    @Autowired
    private  OrderRepository orderRepository;

    @Test
    void saveOrderMethod(){
        Order order = new Order();
        order.setOrderTrackingNumber("100RIC");
        order.setTotalQuantity(5);
        order.setStatus("Pendiente a entrega");
        order.setTotalPrice(new BigDecimal(1000));

        Address address = new Address();
        address.setCity("Santa Cruz de la Sierra");
        address.setStreet("Av Banzer 5to Anillo, Cond. Villa Fátima Casa 23");
        address.setState("Santa Cruz");
        address.setCountry("Bolivia");
        address.setZipCode("000000");

        order.setBillingAdresses(address);
        orderRepository.save(order);
    }

    @Test
    void updateOrderMethod(){

        Long id = 1L;
        Order order = orderRepository.findById(id).get();

        order.setStatus("Entregado");
        order.getBillingAdresses().setZipCode("000");
        Order saveObject = orderRepository.save(order);
        System.out.println("UPDATE Status: "+saveObject.getStatus());
        System.out.println("UPDATE Status: "+saveObject.getBillingAdresses());



        orderRepository.save(order);
    }

}
