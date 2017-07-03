package com.awbeci.model;

public class UserInfo {

    public UserInfo(String userName, String userAge) {
        UserName = userName;
        UserAge = userAge;
    }

    public String getUserName() {

        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String UserName;

    public String getUserAge() {
        return UserAge;
    }

    public void setUserAge(String userAge) {
        UserAge = userAge;
    }

    public String UserAge;
}
