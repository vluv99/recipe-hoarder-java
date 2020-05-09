package com.vluv.recipe_hoarder_web.controllers;

import com.vluv.recipe_hoarder_core.DAO.MenuDAO;
import com.vluv.recipe_hoarder_core.DAO.RecipeDAO;
import com.vluv.recipe_hoarder_core.DAO.UserDAO;
import com.vluv.recipe_hoarder_core.database.Database;
import com.vluv.recipe_hoarder_core.model.Menu;
import com.vluv.recipe_hoarder_core.model.Recipe;
import com.vluv.recipe_hoarder_core.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/recipe-delete-from-menu")
public class DeleteRecipeFromMenuController extends HttpServlet {
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
        RecipeDAO recipeDAO = Database.getInstance().getRecipeDAO();
        MenuDAO menuDAO = Database.getInstance().getMenuDAO();

        int id = Integer.parseInt(request.getParameter("id"));
        int menuId = Integer.parseInt(request.getParameter("menuId"));
        recipeDAO.deleteRecipeFromMenu(id, menuId); //delete recipe from the menu in the database

        for (Menu m : currentUser.getMenuList()) {  //deleting from the user's list
            if (m.getId() == menuId) {
                for (int i = 0; i < m.getMenuRecipes().size(); i++) {
                    if (m.getMenuRecipes().get(i).getId() == id) {
                        m.getMenuRecipes().remove(i);
                        break;
                    }
                }
            }
        }

        response.sendRedirect("../menu.jsp?id=" + menuId);
    }
}
