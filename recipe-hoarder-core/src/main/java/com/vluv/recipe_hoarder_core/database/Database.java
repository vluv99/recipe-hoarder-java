package com.vluv.recipe_hoarder_core.database;

import com.vluv.recipe_hoarder_core.model.Recipe;

import javax.management.InstanceAlreadyExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.crypto.Data;
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

    public void setUp(){
        // like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
        // 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
        entityManagerFactory = Persistence.createEntityManagerFactory("com.vluv.recipe_hoarder_core.model");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void addRecipe(Recipe r){
        entityManager.getTransaction().begin();

        entityManager.persist(r);
        entityManager.getTransaction().commit();
    }

    public List<Recipe> getRecipes(){
        return entityManager.createQuery( "from Recipe ", Recipe.class ).getResultList();
    }

    public Recipe getSingleRecipe(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        for (Recipe r : this.getRecipes()) {
            if (r.getId() == id) {
                return r;
            }
        }

        return null;
    }
}
