package com.vluv.recipe_hoarder_web.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/log-out")
public class LogOutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);

        req.getSession().removeAttribute("email");
        req.getSession().removeAttribute("password");

        resp.sendRedirect("/recipe_hoarder_java_war/");
    }
}
