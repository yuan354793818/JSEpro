package com.test.controller;

import com.test.dto.TestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {


    @RequestMapping("/getpage")
    public String getPage(@ModelAttribute(name = "dto") TestDto dto, Model model) {

        dto.setMsg("111");
        return "/WEB-INF/jsp/test.jsp";
    }

    @RequestMapping("/getpage1")
    public String getPage1(@ModelAttribute(name = "dto") TestDto dto, Model model) {

        dto.setMsg("111");
        return "/WEB-INF/jspx/jtest.jspx";
    }

}
