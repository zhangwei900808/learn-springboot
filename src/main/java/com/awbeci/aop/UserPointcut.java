package com.awbeci.aop;

import com.awbeci.exception.MyException;
import com.awbeci.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
@Aspect
public class UserPointcut {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Pointcut("execution(* com.awbeci.service.UserService.getUserInfoById(int))")
    public void token(){}

    @Before("token()")
    public void checkToken(JoinPoint joinPoint) throws MyException {
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        String token = httpServletRequest.getParameter("token");
        if (token == null){
            throw new MyException("token不存在","10010");
        }
        if(!token.equals("awbeci")){
            throw new MyException("token不正确","10020");
        }
    }

    @AfterReturning(pointcut = "token()",returning = "user")
    public void filterPass(JoinPoint joinPoint, User user){
        user.setPassword("***");
    }

    //优先级最高
    @Around("token()")
    public Object filter(ProceedingJoinPoint pjp) throws Throwable {
        String id = pjp.getArgs()[0].toString();
        if(id.equals("4")){
            throw new MyException("超级管理员不能显示","10030");
        }
        id="100"+id;
        //执行userservice的getUserById方法前执行，把userid参数替换一下
       return pjp.proceed(new Object[]{
                Integer.parseInt(id)
        });
    }
}
