package com.awbeci.service;

import com.awbeci.mapper.IUserMapper;
import com.awbeci.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {

    @Autowired
    IUserMapper userMapper;

    public User getUserInfoById(int userId){
        //token验证
        return userMapper.getUserById(userId);
    }
}
