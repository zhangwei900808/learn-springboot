package com.awbeci.mapper;

import com.awbeci.util.DBHelper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;

@Mapper
public interface IUserCoinMapper {

    @UpdateProvider(type = DBHelper.class,method = "update_user_coin")
    int updateCoins(@Param("user_name") String userName, @Param("coin_value") int coinValue);
}
