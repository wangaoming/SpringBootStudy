package com.example.jsp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.Map;
/**@author ASUS
 *
 */

@Controller
public class WelcomeController {
    @GetMapping("/hello")
    public String hello(Model model,String name){
        model.addAttribute("name",name);
        return "hello";
    }
    @GetMapping("/welcome")
    public  String welcome(Map<String,Object> model,String name){
        model.put("name",name);
        model.put("time", LocalDate.now());
        return  "welcome";
    }

}
