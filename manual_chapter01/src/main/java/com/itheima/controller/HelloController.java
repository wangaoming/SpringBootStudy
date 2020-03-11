package com.itheima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //组合注解 @ResponserBody&Controller
public class HelloController {

    @GetMapping("/hello") //GetMapping:相当于@RequestMapping（value="/hello",RequsetMethod.Get）

    public String hello() {
        return "hello spring boot";
    }
}
