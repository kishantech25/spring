package com.telusko;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
         PrintWriter pw =null;

         //set the content type
        response.setContentType("text/html");

      pw= response.getWriter();

      pw.println("<h1><b>Hello World</b></h1>");


    }
}
