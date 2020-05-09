package com.vluv.recipe_hoarder_web.controllers.filters;

import com.vluv.recipe_hoarder_core.DAO.MenuDAO;
import com.vluv.recipe_hoarder_core.DAO.RecipeDAO;
import com.vluv.recipe_hoarder_core.DAO.UserDAO;
import com.vluv.recipe_hoarder_core.database.Database;
import com.vluv.recipe_hoarder_core.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/api/menu")
public class MenuController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestDispatcher("WEB-INF/add-recipe.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");

        if (title != null){
            //RequestDispatcher rd = request.getRequestDispatcher("recipe");
            Menu menu = new Menu();
            menu.setUserId(currentUser.getId());
            menu.setTitle(title);
            MenuDAO menuDAO = Database.getInstance().getMenuDAO();
            menuDAO.AddMenu(menu); //database update
            currentUser.getMenuList().add(menu); //list update

            response.sendRedirect("../menu-sum.jsp");
        }
        else {
            out.print("Sorry, you must fill out all the fields!");
            RequestDispatcher rd=request.getRequestDispatcher("/recipe_hoarder_java_war/api/menu");
            rd.include(request, response);

        }
    }
}
