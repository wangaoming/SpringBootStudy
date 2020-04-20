package com.example.securitytestdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lenovo
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello security";
    }
    @GetMapping("/dba/hello")
    public String dba() {
        return "hello dba!";
    }
    @GetMapping("/admin/hello")
    public String admin() {
        return "hello user!";
    } @GetMapping("/user/hello")
    public String User() {
        return "hello user!";
    }
}
