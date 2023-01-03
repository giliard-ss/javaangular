package com.comurg.redesoljob.controller;

import com.comurg.redesoljob.model.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/example")
public class ExampleController {

    @GetMapping
    public List<Example> list() {
        List<Example> list = new ArrayList<>();
        Example example = new Example();
        example.setId("3");
        example.setName("Roberta Brito");
        list.add(example);
        return list;
    }
}
