package com.comurg.redesoljob.controller;

import com.comurg.redesoljob.model.Example;
import com.comurg.redesoljob.repository.ExampleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
