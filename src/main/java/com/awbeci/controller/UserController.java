package com.awbeci.controller;

import com.awbeci.mapper.IUserMapper;
import com.awbeci.model.User;
import com.awbeci.model.UserInfo;
import com.awbeci.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    IUserMapper userMapper;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/userinfo")
    public UserInfo getUserInfo(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://192.168.10.10:3306/awbeci?characterEncoding=utf-8",
                    "homestead",
                    "secret");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT  name from users");
            while (rs.next()){
                System.out.print(rs.getString("name"));
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new UserInfo("zhangwei","19");
    }

    @RequestMapping(value = "/userinfo2")
    public String getUserInfo2(){
        List list = jdbcTemplate.queryForList("SELECT  name from users");
        for (Object obj:list){
            System.out.print(((Map)obj).get("name"));
        }
        return "this is userinfo2";
    }

    @RequestMapping(value = "/userinfo3/{uid}")
    public User getUser3(@PathVariable("uid")int id){
        //used aop point cut
        return userService.getUserInfoById(id);
    }

    @RequestMapping(value = "/userinfo4")
    public List<User> getUser4(){
        return userMapper.getAllUsers();
    }

    @RequestMapping(value = "/userinfo",method = RequestMethod.POST)
    public int addUser(@RequestBody User user){
//        return userMapper.addUser(user);
        userMapper.addUser(user);
        return user.id;
    }

    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public int testUser(@RequestBody User user){
//        return userMapper.addUser(user);
        userMapper.addUser2(user);
        return user.id;
    }
}
