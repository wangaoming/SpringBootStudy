package com.example.res.custom.demo.service;

import com.example.res.custom.demo.pojo.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAll();

    Message findOne(Long id);

    Message save(Message message);

    void delete(Long id);

    Message update(Message message);

    Message updateText(Message message);
}