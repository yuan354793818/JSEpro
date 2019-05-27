package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("cros")
public class CrosTestController {

    @CrossOrigin//(accept origin)
    @RequestMapping("/get")
    @ResponseBody
    public String getTest() {

        return "THIS HANDLER CAN VISIT BY CROS";
    }

    @RequestMapping("/getcookie")
    @ResponseBody
    public String getCookie(HttpServletRequest request, HttpServletResponse response) {
        int i=1/0;
        Cookie cookie = new Cookie("myname", "yjy");
        cookie.setPath("/");
        response.addCookie(cookie);
        return "success";
    }

    @RequestMapping("/checkcookie")
    @ResponseBody
    public String checkCookie(@CookieValue(name = "myname",required = true) String cookie) {
        System.out.println("catch cookie : "+cookie);

        return "success";
    }
}
