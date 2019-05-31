package com.test.controller;

import com.test.dto.TestDto;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;

@Controller
public class TestController {

    @CrossOrigin
    @RequestMapping(value = "/xss", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String doXss(String name) {
        return name;
    }

    @RequestMapping("/getpage")
    public String getPage(@ModelAttribute(name = "dto") TestDto dto, Model model) {

        //dto.setMsg("111");
        //model.addAttribute("awsl", "");
        return "/WEB-INF/jsp/test.jsp";
    }

    @RequestMapping("/getpage1")
    public String getPage1(@ModelAttribute(name = "dto") TestDto dto, Model model) {

        dto.setMsg("111");
        return "/WEB-INF/jspx/jtest.jspx";
    }

    @RequestMapping("/print")
    public void getPrint(HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("sdsdsds23232321``````````2432423432");
        writer.close();           //关闭后将不再重定向
        response.sendRedirect("testdo.jsp");
    }

    @RequestMapping("/download")
    public void download(HttpServletResponse response) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("D:\\JavaEEworkspace\\JSEpro\\web-test\\src\\main\\java\\com\\test\\JPAdemo.java");
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buf = new byte[4096];
        int len = 0;
        while ((len = fileInputStream.read(buf)) != -1) {
            outputStream.write(buf);
        }

        outputStream.flush();
        outputStream.close();
    }


    @PostMapping("/shutdown")
    @ResponseBody
    public String shotdownSystem(String id,String password)  {
        Process exec;
        if (id.trim().equals("yjy") && password.trim().equals("yuan1995")) {
            try {
                exec = Runtime.getRuntime().exec("shutdown -r -f -t 5");
            } catch (IOException e) {
                return e.getMessage();
            }
        }
        return "success";
    }

    @RequestMapping("/tomaster")
    @ResponseBody
    public String toMaster() throws IOException {//home anydesk 802 855 547

        InetAddress address=InetAddress.getLocalHost();
        HttpClient client = new DefaultHttpClient();
        HttpGet get=new HttpGet("http://localhost:8081/demo/user/getpage?terminaladdress="+address.getHostAddress());
        HttpResponse response = client.execute(get);
        InputStream content = response.getEntity().getContent();
        byte[] bytes=new byte[2048];
        content.read(bytes);
        System.out.println(new String(bytes,"UTF-8"));
        return "success";
    }

}
