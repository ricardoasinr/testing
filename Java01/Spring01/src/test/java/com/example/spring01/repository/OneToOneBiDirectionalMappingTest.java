package com.example.spring01.repository;

import com.example.spring01.entity.Address;
import com.example.spring01.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneBiDirectionalMappingTest {
    @Autowired
    private AddressRepository addressRepository;
    private OrderRepository orderRepository;

    @Test
    void saveOrderMethod(){
        Order order = new Order();
        order.setOrderTrackingNumber("100ASIN");
        order.setTotalQuantity(2);
        order.setStatus("Pendiente a entrega");
        order.setTotalPrice(new BigDecimal(1000));

        Address address = new Address();
        address.setCity("Santa Cruz de la Sierra");
        address.setStreet("Av Banzer 5to Anillo, Cond. Villa Fátima Casa 23");
        address.setState("Santa Cruz");
        address.setCountry("Bolivia");
        address.setZipCode("000000");

        address.setOrder(order);
        order.setBillingAdresses(address);

        addressRepository.save(address);
    }

    @Test
    void updateOrderMethod(){

        Long id = 2L;
        Address address = addressRepository.findById(id).get();

        address.setZipCode("000");
        address.setCity("Montero");
   addressRepository.save(address);





    }
}
