package com.vluv.recipe_hoarder_core.DAO;

import com.vluv.recipe_hoarder_core.model.Menu;
import com.vluv.recipe_hoarder_core.model.Recipe;

import java.util.List;

public interface RecipeDAO {

    boolean addRecipe(Recipe r);
    List<Recipe> getRecipesOfUser(int userId);
    List<Recipe> getRecipesOfMenu(int menuId);
    Recipe getRecipe(int id);
    boolean deleteRecipe(int recipeId);
    boolean deleteRecipeFromMenu(int menuId);
}
