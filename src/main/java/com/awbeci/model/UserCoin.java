package com.awbeci.model;

/**
 * Created by zhangwei on 2017/7/6.
 */
public class UserCoin {
    public int id;
    public String user_name;
    public int Coin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getCoin() {
        return Coin;
    }

    public void setCoin(int coin) {
        Coin = coin;
    }
}
