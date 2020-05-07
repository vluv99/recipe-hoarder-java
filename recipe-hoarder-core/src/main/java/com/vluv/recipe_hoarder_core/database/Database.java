package com.vluv.recipe_hoarder_core.database;

import com.vluv.recipe_hoarder_core.DAO.MenuDAO;
import com.vluv.recipe_hoarder_core.DAO.RecipeDAO;
import com.vluv.recipe_hoarder_core.DAO.UserDAO;
import com.vluv.recipe_hoarder_core.model.Ingredient;
import com.vluv.recipe_hoarder_core.model.Menu;
import com.vluv.recipe_hoarder_core.model.Recipe;
import com.vluv.recipe_hoarder_core.model.User;

import javax.management.InstanceAlreadyExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;


public class Database {
    private static Database instance;
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public static Database getInstance(){
        if(instance == null){
            try {
                instance = new Database();
            } catch (InstanceAlreadyExistsException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public Database() throws InstanceAlreadyExistsException {
        if(instance != null){
            throw new InstanceAlreadyExistsException("WTF");
        }
        setUp();
    }

    //everyone uses this
    public void setUp(){
        // like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
        // 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
        entityManagerFactory = Persistence.createEntityManagerFactory("com.vluv.recipe_hoarder_core.model");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public UserDAO getUserDAO(){
        return new UserDAO_Impl(entityManager);
    }

    public RecipeDAO getRecipeDAO(){
        return new RecipeDAO_Impl(entityManager);
    }

    public MenuDAO getMenuDAO(){
        return new MenuDAO_Impl(entityManager);
    }






    //TODO*************************** finish DAOs


/*

    //for the ingredients
    public void addIngredient(Ingredient i){
        entityManager.getTransaction().begin();

        entityManager.persist(i);
        entityManager.getTransaction().commit();
    }

    public List<Ingredient> getIngredients(){
        return entityManager.createQuery( "from Ingredient ", Ingredient.class ).getResultList();
    }

    public Ingredient getSingleIngredient(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        for (Ingredient i : this.getIngredients()) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public List<Ingredient> getIngredientsOfRecipe(int recipeId){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Recipe r = getSingleRecipe(recipeId);
        List<Ingredient> list = new ArrayList<>();

        int i = 0;
        for (Ingredient ing : r.getIngredients() ) {
            list.add(i, ing);
            i++;
        }
        return list;
    }

    //menu-recipes
    //deletes
*/
}
