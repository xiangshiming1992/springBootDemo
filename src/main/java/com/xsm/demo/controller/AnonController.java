package com.xsm.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 测试接口（不拦截）
 */
@Controller
@RequestMapping("/api/anon")
public class AnonController {


    @GetMapping("/set/{age}")
    @ResponseBody
    public String addInfo(HttpServletRequest request, @PathVariable String age){
        request.getSession().setAttribute("age",age);
        String info = (String) request.getSession().getAttribute("age");
        return info;
    }

    @RequestMapping("/get/{age}")
    @ResponseBody
    public String TestSession(HttpServletRequest req, HttpServletResponse resp, @PathVariable String age){
        String a = (String) req.getSession().getAttribute("age");
        return a;
    }
}
