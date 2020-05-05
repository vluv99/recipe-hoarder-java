package com.vluv.recipe_hoarder_core.database;

import com.vluv.recipe_hoarder_core.model.Recipe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class Database {
    private EntityManagerFactory entityManagerFactory;

    public void setUp(){
        // like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
        // 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
        entityManagerFactory = Persistence.createEntityManagerFactory("com.vluv.recipe_hoarder_core.model");
    }

    public void addRecipe(Recipe r){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(r);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Recipe> getRecipes(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Recipe> result = entityManager.createQuery( "from Recipe ", Recipe.class ).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
}
