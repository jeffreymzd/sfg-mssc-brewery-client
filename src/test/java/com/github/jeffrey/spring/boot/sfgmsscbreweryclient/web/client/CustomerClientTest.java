package com.github.jeffrey.spring.boot.sfgmsscbreweryclient.web.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jeffrey.spring.boot.sfgmsscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by jeffreymzd on 3/15/20
 */
@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getCustomerById() {

        CustomerDto dto = customerClient.getCustomerById(UUID.randomUUID());

        assertNotNull(dto);

        System.out.println(dto);
    }

    @Test
    void saveNewCustomer() {

        CustomerDto dto = CustomerDto.builder().id(UUID.randomUUID()).customerName("New Customer").build();

        URI uri = customerClient.saveNewCustomer(dto);

        assertNotNull(uri);

        System.out.println(uri);
    }

    @Test
    void updateCustomer() {

        CustomerDto dto = CustomerDto.builder().id(UUID.randomUUID()).customerName("New Customer").build();

        customerClient.updateCustomer(UUID.randomUUID(), dto);
    }

    @Test
    void deleteCustomer() {

        customerClient.deleteCustomer(UUID.randomUUID());
    }
}