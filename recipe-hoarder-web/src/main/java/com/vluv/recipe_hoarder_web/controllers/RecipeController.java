package com.vluv.recipe_hoarder_web.controllers;

import com.vluv.recipe_hoarder_core.DAO.RecipeDAO;
import com.vluv.recipe_hoarder_core.DAO.UserDAO;
import com.vluv.recipe_hoarder_core.database.Database;
import com.vluv.recipe_hoarder_core.model.Ingredient;
import com.vluv.recipe_hoarder_core.model.Recipe;

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

@WebServlet("/api/recipe")
public class RecipeController extends HttpServlet {

    //We need to return the list of recipes
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestDispatcher("WEB-INF/add-recipe.jsp").forward(req, resp);
    }

    //We are adding a new recipe
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String descr = request.getParameter("description");
        String cathegory = request.getParameter("cathegory");

        String str = request.getParameter("ingredients");
        List<String > s = Arrays.asList(str.split("\\r?\\n"));

        List<Ingredient> ingredients = new  ArrayList<Ingredient>();
        for (int i = 0; i<s.size(); i++){
            Ingredient ing = new Ingredient();
            ing.setName_amount(s.get(i));
            ingredients.add(ing);
        }

        str = request.getParameter("directions");
        List<String> direction = Arrays.asList(str.split("\\r?\\n"));

        if (name != null && descr != null && cathegory != null && !ingredients.isEmpty() && !direction.isEmpty()){
            //RequestDispatcher rd = request.getRequestDispatcher("recipe");
            Recipe recipe = new Recipe();
            recipe.setName(name);
            recipe.setDescription(descr);
            recipe.setCathegory(cathegory);
            recipe.setIngredients(ingredients);
            recipe.setDirections(direction);
            recipe.setUserId((Integer) session.getAttribute("id")); //TODO set user id
            RecipeDAO r = Database.getInstance().getRecipeDAO(); //TODO fix add method, it doesnt write out everything to the database
            r.addRecipe(recipe);
        }
        else {
            out.print("Sorry, you must fill out all the fields!");
            RequestDispatcher rd=request.getRequestDispatcher("/recipe_hoarder_java_war/api/recipe");
            rd.include(request, response);

        }
    }
}
