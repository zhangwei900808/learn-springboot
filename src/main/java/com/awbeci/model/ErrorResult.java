package com.awbeci.model;

public class ErrorResult {
    public String errorNo;
    public String errorMsg;
    public int status;

    public ErrorResult(String errorNo, String errorMsg, int  status) {
        this.errorNo = errorNo;
        this.errorMsg = errorMsg;
        this.status = status;
    }

    public ErrorResult(String errorNo, String errorMsg) {
        this.errorNo = errorNo;
        this.errorMsg = errorMsg;
    }

    public String getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(String errorNo) {
        this.errorNo = errorNo;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
