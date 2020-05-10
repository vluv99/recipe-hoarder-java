package com.vluv.recipe_hoarder_web.controllers;

import com.vluv.recipe_hoarder_core.DAO.RecipeDAO;
import com.vluv.recipe_hoarder_core.DAO.UserDAO;
import com.vluv.recipe_hoarder_core.database.Database;
import com.vluv.recipe_hoarder_core.model.Direction;
import com.vluv.recipe_hoarder_core.model.Ingredient;
import com.vluv.recipe_hoarder_core.model.Recipe;
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
        User currentUser = (User) session.getAttribute("currentUser");


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");

        String url = request.getParameter("url");
        if (url == null){
            manualRecipeAdd(request, response, currentUser, out);
        }else {
            urlRecipeAdd(request, response, currentUser, out, url);
        }

    }

    private void urlRecipeAdd(HttpServletRequest request, HttpServletResponse response, User currentUser, PrintWriter out, String url) throws IOException, ServletException {
        Recipe recipe = Database.getInstance().getRecipeDAO().addRecipeFromURL(currentUser, url);

        if(recipe != null){
            currentUser.getRecipeList().add(recipe);
            response.sendRedirect("../recipe-sum.jsp");
        }else {
            out.print("Sorry, you must fill out all the field!");
            RequestDispatcher rd=request.getRequestDispatcher("/recipe_hoarder_java_war/api/recipe");
            rd.include(request, response);
        }
    }

    private void manualRecipeAdd(HttpServletRequest request, HttpServletResponse response, User currentUser, PrintWriter out) throws IOException, ServletException {
        String name = request.getParameter("name");
        String descr = request.getParameter("description");
        String cathegory = request.getParameter("cathegory");

        String str = request.getParameter("ingredients");
        List<String> s = Arrays.asList(str.split("\\r?\\n"));

        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        for (int i = 0; i<s.size(); i++){
            Ingredient ing = new Ingredient();
            ing.setName_amount(s.get(i));
            ingredients.add(ing);
        }

        str = request.getParameter("directions");
        List<String> d = Arrays.asList(str.split("\\r?\\n"));
        List<Direction> direction = new ArrayList<>();
        for (int i = 0; i<d.size(); i++){
            direction.add(new Direction(null, i, d.get(i)));
        }


        if (name != null && descr != null && cathegory != null && !ingredients.isEmpty() && !direction.isEmpty()){
            //RequestDispatcher rd = request.getRequestDispatcher("recipe");
            Recipe recipe = new Recipe();
            recipe.setUserId(currentUser.getId());
            recipe.setName(name);
            recipe.setDescription(descr);
            recipe.setCathegory(cathegory);
            recipe.setIngredients(ingredients);
            recipe.setDirections(direction);
            RecipeDAO r = Database.getInstance().getRecipeDAO();
            r.addRecipe(recipe);
            currentUser.getRecipeList().add(recipe);

            response.sendRedirect("../recipe-sum.jsp");
        }
        else {
            out.print("Sorry, you must fill out all the fields!");
            RequestDispatcher rd=request.getRequestDispatcher("/recipe_hoarder_java_war/api/recipe");
            rd.include(request, response);

        }
    }
}
