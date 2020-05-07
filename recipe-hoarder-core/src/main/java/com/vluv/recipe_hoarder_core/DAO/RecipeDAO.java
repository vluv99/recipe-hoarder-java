package com.vluv.recipe_hoarder_core.DAO;

import com.vluv.recipe_hoarder_core.model.Menu;
import com.vluv.recipe_hoarder_core.model.Recipe;

import java.util.List;

public interface RecipeDAO {

    boolean addRecipe(Recipe r);
    List<Recipe> getRecipes();
    Recipe getSingleRecipe(int id);

    List<Recipe> getRecipesOfUser(int userId);

    void deleteRecipe(int recipeId);
}
