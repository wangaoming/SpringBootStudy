package com.example.jdbcfiisrtdemo.repository.impl;

import com.example.jdbcfiisrtdemo.pojo.Message;
import com.example.jdbcfiisrtdemo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ASUS
 * @description : Message的数据接口实现类
 */
@Repository
public class MessageRepositoryImpl implements MessageRepository {
@Autowired
private JdbcTemplate jdbcTemplate;
    @Override
    public List<com.example.jdbcfiisrtdemo.pojo.Message> findAll() {
        return jdbcTemplate.query("select * from message",
                (resultSet, i) -> Message.builder()
                        .msgId(resultSet.getInt("msg_id"))
                        .msgText(resultSet.getString("msg_text"))
                        .msgSummary(resultSet.getString("msg_summary"))
                        .build());
//        return jdbcTemplate.queryForList("select * from message", com.example.jdbcfiisrtdemo.pojo.Message.class);
    }

    @Override
    public com.example.jdbcfiisrtdemo.pojo.Message findById(Integer id) {
        return jdbcTemplate.queryForObject("select * from message where id=?",new Object[]{id}, Message.class);
    }

    @Override
    public int insert(com.example.jdbcfiisrtdemo.pojo.Message message) {
        return jdbcTemplate.update("insert into message(msg_text, msg_summary) values(?, ?)",
                message.getMsgText(), message.getMsgSummary());
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from message where id=?", id);
    }

    @Override
    public int update(com.example.jdbcfiisrtdemo.pojo.Message message) {
        return jdbcTemplate.update("update message set msg_text=? and msg_summary=? where id=?",
                message.getMsgText(), message.getMsgSummary(), message.getMsgId());
    }

    @Override
    public int updateText(com.example.jdbcfiisrtdemo.pojo.Message message) {
       return jdbcTemplate.update("update message set msg_text=? where id=?",
                message.getMsgText(), message.getMsgId());
    }

    @Override
    public int[] batchInsert(List<Message> messages) {
         return jdbcTemplate.batchUpdate("insert into message(msg_text, msg_summary) values(?,?)",
                new BatchPreparedStatementSetter(){
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, messages.get(i).getMsgText());
                        ps.setString(2, messages.get(i).getMsgSummary());
                    }
                    @Override
                    public int getBatchSize() {
                        return messages.size();
                    }
                });
    }


}