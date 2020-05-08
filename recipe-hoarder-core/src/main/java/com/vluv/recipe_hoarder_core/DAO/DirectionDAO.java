package com.vluv.recipe_hoarder_core.DAO;

import com.vluv.recipe_hoarder_core.model.Recipe;

import java.util.List;

public interface DirectionDAO {
    boolean addDirection(String s);
    List<String> getDirectionOfRecipe(int recipeId);
    boolean deleteDirection(int recipeId);
}
