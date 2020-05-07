package com.vluv.recipe_hoarder_core.database;

import com.vluv.recipe_hoarder_core.DAO.UserDAO;
import com.vluv.recipe_hoarder_core.model.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAO_Impl implements UserDAO {
    private EntityManager entityManager;

    public UserDAO_Impl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean addUser(User u) {
        try {
            entityManager.getTransaction().begin();

            entityManager.persist(u);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery( "from User ", User.class ).getResultList();
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getSingleUser(int id) {

        for (User u : this.getUsers()) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }


}
