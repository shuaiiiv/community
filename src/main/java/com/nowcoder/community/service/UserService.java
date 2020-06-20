package com.nowcoder.community.service;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id)
    {
        return userMapper.selectByid(id);
    }
}
