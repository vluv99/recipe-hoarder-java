package com.vluv.recipe_hoarder_core.database;

import com.aper_lab.scraperlib.RecipeAPIService;
import com.vluv.recipe_hoarder_core.DAO.MenuDAO;
import com.vluv.recipe_hoarder_core.DAO.RecipeDAO;
import com.vluv.recipe_hoarder_core.DAO.UserDAO;

import javax.management.InstanceAlreadyExistsException;


public class Database {
    private static Database instance;
    //private EntityManager entityManager;
    //private EntityManagerFactory entityManagerFactory;

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
        //entityManagerFactory = Persistence.createEntityManagerFactory("com.vluv.recipe_hoarder_core.model");
        //entityManager = entityManagerFactory.createEntityManager();
        RecipeAPIService.INSTANCE.initApi(new RecipeScraperDatabase());

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

    }

    public UserDAO getUserDAO() {
        return new UserDAO_Impl();
    }

    public RecipeDAO getRecipeDAO() {
        return new RecipeDAO_Impl();
    }

    public MenuDAO getMenuDAO() {
        return new MenuDAO_Impl();
    }

}
