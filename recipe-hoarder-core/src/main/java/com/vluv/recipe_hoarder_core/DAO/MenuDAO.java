package com.vluv.recipe_hoarder_core.DAO;

import com.vluv.recipe_hoarder_core.model.Menu;
import com.vluv.recipe_hoarder_core.model.Recipe;

import java.util.List;

public interface MenuDAO {

    boolean AddMenu(Menu m);

    Menu getMenu(int id);
    List<Menu> getMenusOfUser(int userId);

    boolean deleteMenu(int menuId);

}
