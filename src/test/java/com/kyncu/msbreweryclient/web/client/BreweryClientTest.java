package com.kyncu.msbreweryclient.web.client;

import com.kyncu.msbreweryclient.web.model.BeerDto;
import com.kyncu.msbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void saveNewBeer() {
        URI uri = breweryClient.saveNewBeer(BeerDto.builder().beerName("sample").build());
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void updateBeer() {
        breweryClient.updateBeer(UUID.randomUUID(), BeerDto.builder().beerName("sample").build());
    }

    @Test
    void deleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDto customerDto = breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void saveNewCustomer() {
        URI uri = breweryClient.saveNewCustomer(CustomerDto.builder().name("sample").build());
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void updateCustomer() {
        breweryClient.updateCustomer(UUID.randomUUID(), CustomerDto.builder().name("sample").build());
    }

    @Test
    void deleteCustomer() {
        breweryClient.deleteCustomer(UUID.randomUUID());
    }


}