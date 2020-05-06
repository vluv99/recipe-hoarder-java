package com.vluv.recipe_hoarder_web.controllers;

import com.vluv.recipe_hoarder_core.database.Database;
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
        List<String> ingredients = Arrays.asList(str.split("\\r?\\n"));

        str = request.getParameter("description");
        List<String> direction = Arrays.asList(str.split("\\r?\\n"));

        if (name != null && descr != null && cathegory != null && !ingredients.isEmpty() && !direction.isEmpty()){
            //RequestDispatcher rd = request.getRequestDispatcher("recipe");
            Recipe recipe = new Recipe();
            recipe.setName(name);
            recipe.setDescription(descr);
            recipe.setCathegory(cathegory);
            recipe.setIngredients(ingredients);
            recipe.setDirections(direction);
            Database.getInstance().addRecipe(recipe);
        }
        else {
            out.print("Sorry UserName or Password Error!");
            RequestDispatcher rd=request.getRequestDispatcher("/recipe_hoarder_java_war");
            rd.include(request, response);

        }
    }
}
