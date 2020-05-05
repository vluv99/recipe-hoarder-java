package com.vluv;

import com.vluv.recipe_hoarder_core.database.Database;
import com.vluv.recipe_hoarder_core.model.Recipe;

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

        Database asd = new Database();
        asd.setUp();

        Recipe recipe = new Recipe();
        recipe.setName("Gulash");

        asd.addRecipe(recipe);

        List<Recipe> recipeList = asd.getRecipes();

        for (Recipe r : recipeList ) {
            System.out.println(r.getName());
        }
    }
}
