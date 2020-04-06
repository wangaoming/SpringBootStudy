package com.example.jdbcfiisrtdemo.repository;


import com.example.jdbcfiisrtdemo.pojo.Message;

import java.util.List;


/**
 * @author Lenovo
 */
public interface MessageRepository {
    List<com.example.jdbcfiisrtdemo.pojo.Message> findAll();
//增删改查
com.example.jdbcfiisrtdemo.pojo.Message findById(Integer id);
    int insert(Message message);

    int delete(Long id);

    int update(Message message);

    int updateText(Message message);
    int[] batchInsert(List<Message> messages);
}