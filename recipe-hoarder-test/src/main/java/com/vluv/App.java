package com.vluv;

import com.vluv.recipe_hoarder_core.DAO.RecipeDAO;
import com.vluv.recipe_hoarder_core.DAO.UserDAO;
import com.vluv.recipe_hoarder_core.database.Database;
import com.vluv.recipe_hoarder_core.model.Direction;
import com.vluv.recipe_hoarder_core.model.Ingredient;
import com.vluv.recipe_hoarder_core.model.Recipe;
import com.vluv.recipe_hoarder_core.model.User;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );

        Database asd = Database.getInstance();
        asd.setUp();
        RecipeDAO recipeDAO = asd.getRecipeDAO();
       /* UserDAO userDAO = asd.getUserDAO();

        userDAO.addUser(new User("Testy","asdasd","asd@asd.com","68752"));

        User login = userDAO.login("asd@asd.com","asdasd");
        System.out.println("Login: " + login.getName());



        Recipe r =new Recipe(login.getId(),"Flour","Meat meat","MEAT!");
        r.getDirections().add(new Direction(r.getId(),0,"asdasd0"));
        r.getDirections().add(new Direction(r.getId(),1,"asdasd1"));
        r.getDirections().add(new Direction(r.getId(),2,"asdasd2"));

        r.getIngredients().add(new Ingredient(r.getId(),"10kg liszt"));
        r.getIngredients().add(new Ingredient(r.getId(),"1db alma"));
        //recipeDAO.addRecipe(r);

        List<Recipe> recipes = recipeDAO.getRecipesOfUser(login.getId());
        for (Recipe rec : recipes) {
            System.out.println(rec.getName());


            for (Ingredient d : rec.getIngredients()) {
                System.out.println("- " + d.getName_amount());
            }

            for (Direction d : rec.getDirections()) {
                System.out.println(d.getOrderNumber() + " : "+ d.getDirection());
            }

        }*/

        recipeDAO.addRecipeFromURL(null, "https://www.delish.com/cooking/recipe-ideas/recipes/a52182/hot-cross-buns-recipe/");
        //System.out.println();
    }
}
