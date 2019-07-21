package com.test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class DemoServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&& "+config.getServletContext().getRealPath(""));
    }
}
