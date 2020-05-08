package com.vluv.recipe_hoarder_core.database;

import com.vluv.recipe_hoarder_core.DAO.IngredientDAO;
import com.vluv.recipe_hoarder_core.DAO.MenuDAO;
import com.vluv.recipe_hoarder_core.DAO.RecipeDAO;
import com.vluv.recipe_hoarder_core.DAO.UserDAO;

import javax.management.InstanceAlreadyExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Database {
    private static Database instance;
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public static Database getInstance() {
        if (instance == null) {
            try {
                instance = new Database();
            } catch (InstanceAlreadyExistsException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public Database() throws InstanceAlreadyExistsException {
        if (instance != null) {
            throw new InstanceAlreadyExistsException("WTF");
        }
        setUp();
    }

    //everyone uses this
    public void setUp() {
        // like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
        // 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
        entityManagerFactory = Persistence.createEntityManagerFactory("com.vluv.recipe_hoarder_core.model");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public UserDAO getUserDAO() {
        return new UserDAO_Impl(entityManager);
    }

    public RecipeDAO getRecipeDAO() {
        return new RecipeDAO_Impl(entityManager);
    }

    public MenuDAO getMenuDAO() {
        return new MenuDAO_Impl(entityManager);
    }

    public IngredientDAO getIngredientDAO() {
        return new IngredientDAO_Impl(entityManager);
    }


}
