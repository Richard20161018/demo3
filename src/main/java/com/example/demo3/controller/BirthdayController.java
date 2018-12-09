package com.example.demo3.controller;

import com.example.demo3.bean.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * @auther: wangchengdong
 * @date: 2018/12/7 18:19
 * @description:
 */
@RestController
@RequestMapping("/birthday")
public class BirthdayController {

    private static long day = 60*60*24*1000;

    @PostMapping("calculate")
    public Response<HashMap> calculateSurvivedTime(@RequestParam(name = "name") String name,@RequestParam(name = "birthday") String birthday) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
        Date birth = format.parse(birthday);
        long survivedTime = now.getTimeInMillis() - birth.getTime();
        //已经活的天数
        long survivedDay = survivedTime / day;
        HashMap<String, Object> result = new HashMap<>();

        long wholeTime = 85*356*day;
        long survivingDay = (wholeTime - survivedTime)/day;
        result.put("survivedDay", survivedDay);
        result.put("survivingDay", survivingDay);
        String message = name+"小主，乐观的估计你能活到85岁，你还有"+survivingDay+"天可以活";
        result.put("message",message);
        return new Response<>(Response.CODE_SUCCESS,"ok",result);
    }

}
