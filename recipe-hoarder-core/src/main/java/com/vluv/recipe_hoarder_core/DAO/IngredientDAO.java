package com.vluv.recipe_hoarder_core.DAO;

import com.vluv.recipe_hoarder_core.model.Ingredient;

import java.util.List;

public interface IngredientDAO {

    boolean addIngredient(Ingredient i);
    List<Ingredient> getIngredientsOfRecipe(int recipeId);
    Ingredient getIngredient(int id);
    boolean deleteIngredient(int ingredientId);
}
