package com.backend.springboot1.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/world")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/you")
    public String helloYou(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello " + name;
    }
}
