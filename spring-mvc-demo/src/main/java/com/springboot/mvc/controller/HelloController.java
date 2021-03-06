package com.springboot.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class HelloController {
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    public String hello(Model model) {
        // 使用resources/templates/hello.html作为模板
        // 返回的字符串为hello.html的名称
        model.addAttribute("info", "Hello, spring boot");
        return "hello";
    }
}
