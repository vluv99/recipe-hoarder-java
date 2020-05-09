package com.vluv.recipe_hoarder_web.controllers;

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

@WebServlet("/api/recipe-ingredients-to-shopping-list")
public class GetIngredientsFromRecipeController extends HttpServlet {

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

        int recipeId = Integer.parseInt(request.getParameter("id"));
        Recipe recipe = recipeDAO.getRecipe(recipeId);

        List<Ingredient> ingredients = recipe.getIngredients();
        List<ShoppingList_Item> shoppingList = new ArrayList<ShoppingList_Item>();

        for (Ingredient i : ingredients) {
            ShoppingList_Item shoppingListItem = new ShoppingList_Item();
            shoppingListItem.setId(i.getId());
            shoppingListItem.setUserId(currentUser.getId());
            shoppingListItem.setName_amount(i.getName_amount());

            shoppingList.add(shoppingListItem);
        }

        for (ShoppingList_Item item : shoppingList) {
            userDAO.addShoppingListIngredient(item); //add ingredients to shopping list database
            currentUser.getShoppingList().add(item); //add it to the current user's shopping list as well
        }

        response.sendRedirect("../shopping-list.jsp");
    }
}
