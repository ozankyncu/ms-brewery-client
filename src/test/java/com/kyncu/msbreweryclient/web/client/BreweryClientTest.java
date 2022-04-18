package com.kyncu.msbreweryclient.web.client;

import com.kyncu.msbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

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


}