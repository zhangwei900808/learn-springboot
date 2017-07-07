package com.awbeci.service;

import com.awbeci.mapper.IUserCoinMapper;
import com.awbeci.util.DBHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserCoinService {

    @Autowired
    IUserCoinMapper userCoinMapper;

    @Transactional
    public boolean updateCoin(String fromUser,String toUser,int coin){
        if (userCoinMapper.updateCoins(fromUser,coin)==1){
            if (userCoinMapper.updateCoins(toUser,-coin)!=1){
                throw new RuntimeException("error:转账失败");
            }
            return true;
        }
        else {
            return false;
        }
    }
}
