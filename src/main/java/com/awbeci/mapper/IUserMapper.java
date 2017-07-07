package com.awbeci.mapper;

import com.awbeci.model.User;
import com.awbeci.util.DBHelper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IUserMapper {

    @Select("select id,name,email,password from users where id=#{uid}")
    User getUserById(@Param("uid") int userid);

    @Select("select id,name,email,password from users")
    List<User> getAllUsers();

    @Insert("insert into users(name,email,password) values(#{name},#{email},#{password})")
    @SelectKey(keyProperty = "id",before=false,resultType = int.class,statement = "select LAST_INSERT_ID()")
    int addUser(User user);

    @InsertProvider(type = DBHelper.class,method = "insert_into_user")
    @SelectKey(keyProperty = "id",before=false,resultType = int.class,statement = "select LAST_INSERT_ID()")
    int addUser2(User user);
}

















