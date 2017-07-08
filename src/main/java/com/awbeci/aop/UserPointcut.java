package com.awbeci.aop;

import com.awbeci.exception.MyException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class UserPointcut {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Pointcut("execution(* com.awbeci.service.UserService.getUserInfoById(int))")
    public void token(){}

    @Before("token()")
    public void checkToken() throws MyException {
        String token = httpServletRequest.getParameter("token");
        if (token == null){
            throw new MyException("token不存在","10010");
        }
        if(!token.equals("awbeci")){
            throw new MyException("token不正确","10020");
        }
    }
}
