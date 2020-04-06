package com.example.jdbcfiisrtdemo.repository;

import com.example.jdbcfiisrtdemo.pojo.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MessageRepositoryTest {
    @Autowired
    private  MessageRepository messageRepository;

    @Test
    @Order(1)
    void findAll() {
        messageRepository.findAll().forEach(
                message -> log.info("查询的数据：{}",message.toString())
        );
    }

    @Test
    @Order(2)
    void findById() {
    }

    @Test
    @Order(3)
    void insert() {
       Message message = Message.builder().msgText("niit").msgSummary("学校").build();
        int num = messageRepository.insert(message);
        log.info("插入的数据条数： {}", num);

    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void updateText() {
    }
}