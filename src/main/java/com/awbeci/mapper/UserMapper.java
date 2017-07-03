package com.awbeci.mapper;

import com.awbeci.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select id,name,email,password from users where id=#{uid}")
    User getUserById(@Param("uid") int userid);

    @Select("select id,name,email,password from users")
    List<User> getAllUsers();

    @Insert("insert into users(name,email,password) values(#{name},#{email},#{password})")
    int addUser(User user);
}
