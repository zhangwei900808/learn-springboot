package com.awbeci.controller;

import com.awbeci.model.UserCoin;
import com.awbeci.service.UserCoinService;
import com.awbeci.util.DBHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserCoinController {

    @Autowired
    UserCoinService userCoinService;

    @RequestMapping(value = "/user/coin",method = RequestMethod.PUT)
    public String updateCoin(@RequestBody List<UserCoin> userCoins){
//        return new DBHelper().update_user_coin();
        UserCoin fromUser = userCoins.get(0);//源用户
        UserCoin toUser = userCoins.get(1);//目标用户
        if(userCoinService.updateCoin(fromUser.getUser_name(),toUser.getUser_name(),fromUser.getCoin()))
        {
            return "Success";

        }
        else{
            return "error";
        }
    }
}
