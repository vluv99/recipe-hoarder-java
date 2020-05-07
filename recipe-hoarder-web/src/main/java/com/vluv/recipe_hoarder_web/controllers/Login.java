package com.vluv.recipe_hoarder_web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n=request.getParameter("userMail");
        String p=request.getParameter("userPass");

        if(p.equals("servlet")){
            RequestDispatcher rd = request.getRequestDispatcher("recipe-sum.jsp");
            session.setAttribute("email", n);
            session.setAttribute("password", p);
            rd.forward(request, response);
        }
        else {
            out.print("Sorry UserName or Password Error!");
            RequestDispatcher rd=request.getRequestDispatcher("/recipe_hoarder_java_war");
            rd.include(request, response);

        }
    }
}
