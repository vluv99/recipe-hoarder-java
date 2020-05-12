package recipe_hoarder_core.DAO;

import recipe_hoarder_core.model.Menu;

import java.util.List;

public interface MenuDAO {

    boolean AddMenu(Menu m);

    Menu getMenu(int id);
    List<Menu> getMenusOfUser(int userId);

    boolean deleteMenu(int menuId);

}
