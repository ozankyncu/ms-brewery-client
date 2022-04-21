package com.kyncu.msbreweryclient.web.client;

import com.kyncu.msbreweryclient.web.model.BeerDto;
import com.kyncu.msbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "kyncu.brewery", ignoreUnknownFields = false)
public class BreweryClient {
    public static final String BEER_PATH_V1 = "/api/v1/beer/";
    public static final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

    private String apiHost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID beerId) {
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + beerId.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID beerId, BeerDto beerDto) {
        restTemplate.put(apiHost + BEER_PATH_V1 + "/" + beerId.toString(), beerDto);
    }

    public void deleteBeer(UUID beerId) {
        restTemplate.delete(apiHost + BEER_PATH_V1 + "/" + beerId.toString());
    }

    public CustomerDto getCustomerById(UUID customerId) {
        return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + customerId.toString(),
                CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        restTemplate.put(apiHost + CUSTOMER_PATH_V1 + "/" + customerId.toString(), customerDto);
    }

    public void deleteCustomer(UUID customerId) {
        restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + "/" + customerId.toString());
    }


    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
