package com.example.controller;

import com.example.model.Example;
import com.example.repository.ExampleRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/example")
@AllArgsConstructor
public class ExampleController {

    private final ExampleRepository exampleRepository;

    private final Environment env;

  /*  @GetMapping
    public List<Example> list() {
        return exampleRepository.findAll();
    }
*/
    @GetMapping
    public String version(){
        return env.getProperty("version");
    }
}