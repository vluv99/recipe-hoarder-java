package com.vluv.recipe_hoarder_core.database;

import com.vluv.recipe_hoarder_core.DAO.RecipeDAO;
import com.vluv.recipe_hoarder_core.model.Recipe;
import com.vluv.recipe_hoarder_core.model.User;

import javax.persistence.EntityManager;
import java.util.List;

public class RecipeDAO_Impl implements RecipeDAO {
    private EntityManager entityManager;

    public RecipeDAO_Impl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean addRecipe(Recipe r) {
        entityManager.getTransaction().begin();

        entityManager.persist(r);
        entityManager.getTransaction().commit();

        return true;
    }

    @Override
    public List<Recipe> getRecipes() {
        return entityManager.createQuery( "from Recipe ", Recipe.class ).getResultList();
    }

    @Override
    public Recipe getSingleRecipe(int id) {
        entityManager.getTransaction().begin();

        for (Recipe r : this.getRecipes()) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    @Override
    public List<Recipe> getRecipesOfUser(int userId) {
        return null;
    }

    @Override
    public void deleteRecipe(int recipeId) {
        entityManager.getTransaction().begin();

        Recipe r = this.getSingleRecipe(recipeId);

        entityManager.remove(r);
        entityManager.getTransaction().commit();
    }
}
