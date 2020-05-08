package com.vluv.recipe_hoarder_core.database;

import com.vluv.recipe_hoarder_core.DAO.DirectionDAO;
import com.vluv.recipe_hoarder_core.model.Direction;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class DirectionDAO_Impl implements DirectionDAO {
    //private EntityManager entityManager;

    public DirectionDAO_Impl(EntityManager entityManager) {
        //this.entityManager = entityManager;
    }

    public boolean addDirection(Direction step) {
        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("INSERT INTO Directions (recipeId, orderNumber, direction) VALUES (?,?,?)")
        ) {

            //pst.setInt(1, step.getUserId());
            //pst.setInt(2, step.getMenuId());
            //pst.setString(3, step.getName());

            return pst.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't add the recipe!");
            return false;
        }
    }

    @Override
    public boolean addDirection(String s) {
        return false;
    }

    @Override
    public List<String> getDirectionOfRecipe(int recipeId) {
        return null;
    }

    @Override
    public boolean deleteDirection(int recipeId) {
        return false;
    }
}
