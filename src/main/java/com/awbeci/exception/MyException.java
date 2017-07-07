package com.awbeci.exception;

public class MyException extends Exception{

    public String errorNo;

    public String getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(String errorNo) {
        this.errorNo = errorNo;
    }

    public MyException(String message,String errorNo) {
        super(message);
        this.errorNo = errorNo;
    }

    public MyException(String message) {
        super(message);
    }
}
