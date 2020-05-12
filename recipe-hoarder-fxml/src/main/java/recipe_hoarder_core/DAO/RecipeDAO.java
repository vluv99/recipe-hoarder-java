package recipe_hoarder_core.DAO;

import recipe_hoarder_core.model.Recipe;
import recipe_hoarder_core.model.User;

import java.util.List;

public interface RecipeDAO {

    boolean addRecipe(Recipe r);
    Recipe addRecipeFromURL(User u, String s);
    List<Recipe> getRecipesOfUser(int userId);
    Recipe getRecipe(int id);
    boolean deleteRecipe(int recipeId);
    List<Recipe> getRecipesOfMenu(int menuId);
    boolean deleteRecipeFromMenu(int recipeId, int menuId) ;
    boolean addRecipeToMenu(Recipe r, int menuId);
}
