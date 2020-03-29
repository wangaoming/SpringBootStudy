package com.spring.restful.service;

import com.spring.restful.exception.CustomException;
import com.spring.restful.pojo.Message;

import java.util.List;


public interface MessageService {
    List<Message> findAll();
    Message findOne(Long id);
    Message save(Message message) throws CustomException;
    void delete(Long id);
    Message update(Message message) throws CustomException;
    Message updateText(Message message) throws CustomException;
}
