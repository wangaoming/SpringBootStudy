package com.example.iocdemo.service;

import com.example.iocdemo.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
//传统方式
   @Test
   public void test(){
       UserService userService = new UserServiceImpl();
       userService.findAll();
   }

    @Test
    public  void  test2(){
//        对象容器当中拿
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"
        );
//        通过工厂获取Bean
        UserService userService  = (UserService) context.getBean("userService");
        userService.findAll();
    }

}