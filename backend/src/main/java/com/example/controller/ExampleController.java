package com.example.controller;

import com.example.dto.ExampleDTO;
import com.example.repository.ExampleRepository;
import com.example.rest.ExampleRestService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/example")
@AllArgsConstructor
public class ExampleController {

    private final ExampleRepository exampleRepository;
    private final ExampleRestService exampleRestService;
    private final Environment env;

  /*  @GetMapping
    public List<Example> list() {
        return exampleRepository.findAll();
    }
*/
    @GetMapping(value = "/version")
    public String version(){
        return env.getProperty("version");
    }

    @GetMapping(value = "/rest-example")
    public ExampleDTO restExample(){
        return exampleRestService.get();
    }
}
