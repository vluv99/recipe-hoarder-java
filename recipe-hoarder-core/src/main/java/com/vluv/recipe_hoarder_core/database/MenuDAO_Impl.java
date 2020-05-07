package com.vluv.recipe_hoarder_core.database;

import com.vluv.recipe_hoarder_core.DAO.MenuDAO;
import com.vluv.recipe_hoarder_core.model.Menu;
import com.vluv.recipe_hoarder_core.model.Recipe;
import com.vluv.recipe_hoarder_core.model.User;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO_Impl implements MenuDAO {
    private EntityManager entityManager;

    public MenuDAO_Impl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean AddMenu(Menu m) {
        entityManager.getTransaction().begin();

        entityManager.persist(m);
        entityManager.getTransaction().commit();

        return true;
    }

    @Override
    public List<Menu> getMenus() {
        return entityManager.createQuery( "from Menu ", Menu.class ).getResultList();
    }

    @Override
    public Menu getSingleMenu(int id) {

        for (Menu m: this.getMenus()) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;    }

    @Override
    public List<Menu> getMenusOfUser(int userId) {

        /* TODO
        User u = getSingleUser(userId);
        List<Menu> list = new ArrayList<>();

        int i = 0;
        for (Menu m : u.getMenuList() ) {
            list.add(i, m);
            i++;
        }
        return list;*/
        return null;
    }

    @Override
    public void deleteMenu(int menuId) {
        entityManager.getTransaction().begin();

        Menu m = this.getSingleMenu(menuId);

        entityManager.remove(m);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteRecipeFromMenu(int recipeId, int menuId) {
        /* TODO
        entityManager.getTransaction().begin();

        Recipe r = this.getSingleRecipe(recipeId);

        entityManager.remove(r);
        entityManager.getTransaction().commit();

         */
    }
}
