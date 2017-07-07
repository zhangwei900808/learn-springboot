package com.awbeci.controller;

import com.awbeci.exception.MyException;
import com.awbeci.model.ErrorResult;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController implements ErrorController{

    @RequestMapping("/testError")
    public String testError() throws Exception{
        throw new Exception("测试异常");
    }

    @RequestMapping("/testError2")
    public String testError2 () throws Exception{
        throw new MyException("自定义异常","10010");
    }

    @RequestMapping("/error")
    public ErrorResult error (HttpServletResponse response,Exception ex) throws Exception{
        ErrorResult errorResult = new ErrorResult("404",ex.getMessage(),response.getStatus());
        return errorResult;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
