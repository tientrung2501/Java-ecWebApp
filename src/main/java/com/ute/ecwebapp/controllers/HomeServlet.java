package com.ute.ecwebapp.controllers;

import com.ute.ecwebapp.utills.ServletUtills;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/Home/*")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/"))
        {
            path = "/Index";
        }

            switch (path) {
                case "/Index":
                    ServletUtills.forward("/views/vwHome/index.jsp", request, response);
                    break;
                case "/About":
                    ServletUtills.forward("/views/vwHome/about.jsp", request, response);
                    break;
                default:
                    ServletUtills.forward("/views/404.jsp", request, response);
                    break;
            }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
