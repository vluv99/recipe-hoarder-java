package com.vluv.recipe_hoarder_web.controllers;

import com.vluv.recipe_hoarder_core.DAO.UserDAO;
import com.vluv.recipe_hoarder_core.database.Database;
import com.vluv.recipe_hoarder_core.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");

        String mail = request.getParameter("mail");
        String pass = request.getParameter("password");
        String name = request.getParameter("name");
        String addr = request.getParameter("address");

        UserDAO u = Database.getInstance().getUserDAO();
        //for (User user : u.getUsers() ) {
            //TODO check if the email is unique
        //}

        if(!mail.isEmpty() && !pass.isEmpty() && !name.isEmpty() && !addr.isEmpty()){


            User user = new User();
            user.setMail(mail);
            user.setPassword(pass);
            user.setName(name);
            user.setAddress(addr);

            u.addUser(user);

            session.setAttribute("email", mail);
            session.setAttribute("password", pass);
            session.setAttribute("currentUser", user);

            //RequestDispatcher rd = request.getRequestDispatcher("recipe-sum.jsp");
            //rd.forward(request, response);
            response.sendRedirect("recipe-sum.jsp");
        }
        /*
        else {
            out.print("Empty fields!");
            RequestDispatcher rd=request.getRequestDispatcher("/registration.jsp");
            rd.include(request, response);
        }*/
    }
}
