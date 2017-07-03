package com.hellozw;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class News {

    @RequestMapping(value = "/news")
    public String getNews(){
        return "this is news2";
    }
}
