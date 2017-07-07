package com.awbeci.util;

import org.apache.ibatis.jdbc.SQL;


public class DBHelper {
    public String insert_into_user(){
        SQL sqlBuilder = new SQL();
        sqlBuilder.INSERT_INTO("users")
                .VALUES("name,email,password ","#{name},#{email},#{password}");
        return sqlBuilder.toString();
    }

    public String update_user_coin(){
        return new SQL(){
            {
                UPDATE("user_coins");
                SET("coin=coin-#{coin_value}");
                WHERE("user_name=#{user_name} and (coin-#{coin_value})>=0");
            }
        }.toString();
    }
}
