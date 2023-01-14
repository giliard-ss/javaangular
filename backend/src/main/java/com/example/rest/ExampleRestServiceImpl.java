package com.example.rest;

import com.example.dto.ExampleDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class ExampleRestServiceImpl implements ExampleRestService{
    private static final String API = "http://www.boredapi.com/api/activity";

    private RestTemplate restTemplate;

    public ExampleDTO get() {
        return restTemplate.getForObject(API, ExampleDTO.class);
    }
}
