package com.comurg.redesol.controller;

import com.comurg.redesol.model.Example;
import com.comurg.redesol.repository.ExampleRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/example")
@AllArgsConstructor
public class ExampleController {

    private final ExampleRepository exampleRepository;

    @GetMapping
    public List<Example> list() {
        return exampleRepository.findAll();
    }
}
