package com.vluv.recipe_hoarder_web.controllers;

import com.vluv.recipe_hoarder_core.DAO.MenuDAO;
import com.vluv.recipe_hoarder_core.DAO.RecipeDAO;
import com.vluv.recipe_hoarder_core.DAO.UserDAO;
import com.vluv.recipe_hoarder_core.database.Database;
import com.vluv.recipe_hoarder_core.model.Menu;
import com.vluv.recipe_hoarder_core.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/menu-delete")
public class DeleteMenuController extends HttpServlet {
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

        UserDAO userDAO = Database.getInstance().getUserDAO();
        MenuDAO menuDAO = Database.getInstance().getMenuDAO();

        int id = Integer.parseInt(request.getParameter("id"));
        menuDAO.deleteMenu(id); //delete from database

        for (int i = 0; i < currentUser.getMenuList().size(); i++) {  //delete menu from the user's list
            if (id == currentUser.getMenuList().get(i).getId()) {
                currentUser.getMenuList().remove(i);
                break;
            }
        }

        response.sendRedirect("../menu-sum.jsp");
    }
}
