package com.spring.api.swagger.repository;

import com.spring.api.swagger.pojo.Message;

import java.util.List;

// Message的数据访问接口

public interface MessageRepository {
    List<Message> findAll();
    Message findOne(Long id);
    Message save(Message message);
    void delete(Long id);
    Message update(Message message);
    Message updateText(Message message);
}
