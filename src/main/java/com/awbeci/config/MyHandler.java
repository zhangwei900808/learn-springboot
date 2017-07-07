package com.awbeci.config;

import com.awbeci.exception.MyException;
import com.awbeci.model.ErrorResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class MyHandler {

    @ExceptionHandler(value = Exception.class)
    public ErrorResult defaultHandler(Exception ex, HttpServletResponse response){
        ErrorResult errorResult = new ErrorResult("null",ex.getMessage(),response.getStatus());
        return errorResult;
    }

    @ExceptionHandler(value = MyException.class)
    public ErrorResult myHandler(MyException ex, HttpServletResponse response){
        ErrorResult errorResult = new ErrorResult(ex.getErrorNo(),ex.getMessage(),response.getStatus());
        return errorResult;
    }
}
