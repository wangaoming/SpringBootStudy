package com.springboot.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class MyRestController {
    @RequestMapping("/hello")
    public String get() {
        return "Hello Spring Boot";
    }
}
