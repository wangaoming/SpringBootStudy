package com.example.iocdemo.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class UserServiceTest {
    @Test
    public  void  test1(){
//        对象容器当中拿
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"
        );
//        通过工厂获取Bean
        UserService userService  = (UserService) context.getBean("userService");
        userService.findAll();
    }

}