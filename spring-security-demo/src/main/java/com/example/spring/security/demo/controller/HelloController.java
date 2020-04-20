package com.example.spring.security.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //组合注解 @ResponserBody&Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello security";
    }
    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin!";
    }
    @GetMapping("/user/hello")
    public String User() {
        return "hello user!";
    }
    }
