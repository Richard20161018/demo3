package com.example.demo3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: wangchengdong
 * @date: 2018/12/7 15:24
 * @description:
 */
@RestController
@RequestMapping("/main")
public class MainController {

    @GetMapping("/test")
    public String test(){
        return "SUCCESS!!!";
    }
}
