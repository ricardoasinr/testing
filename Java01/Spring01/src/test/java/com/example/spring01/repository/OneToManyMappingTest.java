package com.example.spring01.repository;

import com.example.spring01.entity.Address;
import com.example.spring01.entity.Order;
import com.example.spring01.entity.OrderItem;
import com.example.spring01.entity.Product;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest

public class OneToManyMappingTest {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveOrderMethod(){
        Order order = new Order();
        order.setOrderTrackingNumber("1010ASIN");
        order.setStatus("Pendiente");

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(productRepository.findById(1L).get());
        orderItem.setQuantity(2);
        orderItem.setPrice(orderItem.getProduct().getPrice().multiply(new BigDecimal(2)));
        orderItem.setImageURL("image.png");


        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(productRepository.findById(2L).get());
        orderItem2.setQuantity(2);
        orderItem2.setPrice(orderItem2.getProduct().getPrice().multiply(new BigDecimal(4)));
        orderItem2.setImageURL("image.png");
        order.getOrderItems().add(orderItem);

        order.getOrderItems().add(orderItem2);

        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuantity(6);

        Address address = new Address();
        address.setCity("Santa Cruz de la Sierra");
        address.setStreet("Av Banzer 6to Anillo, Calle Cheruje Casa #23");
        address.setState("Santa Cruz");
        address.setCountry("Bolivia");
        address.setZipCode("000000");

        address.setOrder(order);
        order.setBillingAdresses(address);

        orderRepository.save(order);




    }


}
