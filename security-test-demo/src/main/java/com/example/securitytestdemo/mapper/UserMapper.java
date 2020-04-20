package com.example.securitytestdemo.mapper;

import com.example.securitytestdemo.model.Role;
import com.example.securitytestdemo.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Lenovo
 */
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User loadUserByUsername(String username);
    @Select({"select * from role r",
            "left join user_role ur",
            "on r.id = ur.rid",
            "where ur.uid = #{id}"})
    List<Role> getUserRoleById(Integer id);
}
