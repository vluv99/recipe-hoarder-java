package com.vluv.recipe_hoarder_web.controllers;

import com.vluv.recipe_hoarder_core.DAO.MenuDAO;
import com.vluv.recipe_hoarder_core.DAO.RecipeDAO;
import com.vluv.recipe_hoarder_core.DAO.UserDAO;
import com.vluv.recipe_hoarder_core.database.Database;
import com.vluv.recipe_hoarder_core.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/add-recipe-to-menu")
public class AddRecipeToMenuController extends HttpServlet {
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

        int recipeId = Integer.parseInt(request.getParameter("recipeId"));
        Recipe recipe = recipeDAO.getRecipe(recipeId);
        int menuId = Integer.parseInt(request.getParameter("menuId"));
        List<Menu> menuList = currentUser.getMenuList();

        for (Menu m : menuList) {
            for (int i = 0; i < m.getMenuRecipes().size(); i++){
                if (m.getMenuRecipes().get(i).getId() == recipeId){
                    System.out.println("ERROR: This recipe is already in that menu!");
                    response.sendRedirect("../menu.jsp?id=" + menuId);
                    return;
                }
            }
        }

        recipeDAO.addRecipeToMenu(recipe, menuId);  //adding recipe to the menu in the database

        for (Menu m : currentUser.getMenuList()) {  //adding the local list the recipe too
            if (m.getId() == menuId) {
                m.getMenuRecipes().add(recipe);
            }
        }

        response.sendRedirect("../recipe-sum.jsp");
    }
}
