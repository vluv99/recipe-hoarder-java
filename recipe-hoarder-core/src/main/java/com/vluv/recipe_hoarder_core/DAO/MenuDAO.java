package com.vluv.recipe_hoarder_core.DAO;

import com.vluv.recipe_hoarder_core.model.Menu;

import java.util.List;

public interface MenuDAO {

    boolean AddMenu(Menu m);
    List<Menu> getMenus();

    Menu getSingleMenu(int id);
    List<Menu> getMenusOfUser(int userId);

    void deleteMenu(int menuId);
    void deleteRecipeFromMenu(int recipeId, int menuId);

}
