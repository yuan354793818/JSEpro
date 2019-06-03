package com.test.controller;

import com.test.dto.TestDto;
import com.test.entity.RemoteClient;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@EnableScheduling
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
    public String shotdownSystem(String id, String password) {
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

    private ConcurrentHashMap<String, RemoteClient> clients=new ConcurrentHashMap<>();

    @Scheduled(fixedRate = 5000)
    private void CheckAlive() {
        for (Map.Entry<String, RemoteClient> entry : clients.entrySet()) {
            if (new Date().getTime()-entry.getValue().getLastVisitTime().getTime()>10000){
                System.out.println(entry.getValue());
                System.out.println(">>>>>>>>>>>> may be lose !");
            }
        }
    }

    @RequestMapping("/observe")
    @ResponseBody
    public String toMaster(HttpServletRequest request) throws IOException {//home anydesk 802 855 547
//        String ip = request.getHeader("x-forwarded-for");
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_CLIENT_IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
//        System.out.println("ip : "+ip);
        String id = request.getParameter("id");
        String clientHost = request.getParameter("clientHost");
        String clientPort = request.getParameter("clientPort");
        if (!clients.containsKey(id)) {
            clients.put(id, new RemoteClient(clientHost, clientPort,new Date()));
        }else {
            clients.get(id).setLastVisitTime(new Date());
        }
        System.out.println("id: " + id);
        System.out.println("clientHost: " + clientHost);
        System.out.println("clientPort: " + clientPort);
        return "success";
    }

}
