package com.vluv.recipe_hoarder_core.database;

import com.vluv.recipe_hoarder_core.DAO.IngredientDAO;
import com.vluv.recipe_hoarder_core.model.Ingredient;
import com.vluv.recipe_hoarder_core.model.Recipe;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAO_Impl implements IngredientDAO {
    //private EntityManager entityManager;

    public IngredientDAO_Impl() {
        //this.entityManager = entityManager;
    }

    @Override
    public boolean addIngredient(Ingredient ingredient) {
        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("INSERT INTO ingredient (userId, recipeId, name_amount) VALUES (?,?,?)")
        ) {

            pst.setInt(1, ingredient.getRecipeId());
            pst.setInt(2, ingredient.getRecipeId());
            pst.setString(3, ingredient.getName_amount());

            return pst.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't add the ingredient!");
            return false;
        }
    }

    @Override
    public List<Ingredient> getIngredientsOfRecipe(int recipeId) {

        List<Ingredient> ingredients = new ArrayList<Ingredient>();

        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("SELECT * FROM ingredient WHERE recipeId = ?;")
        ) {

            pst.setInt(1, recipeId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Ingredient ingredient = new Ingredient();
                ingredient.setRecipeId(rs.getInt("userId"));
                ingredient.setRecipeId(rs.getInt("recipeId"));
                ingredient.setName_amount(rs.getString("name_amount"));

                ingredients.add(ingredient);
            }
            return ingredients;
        } catch (Exception e) {
            System.out.println("Can't find the recipe's ingredients!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Ingredient getIngredient(int id) {
        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("SELECT * FROM ingredient WHERE id = ?;")
        ) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Ingredient ingredient = new Ingredient();
                ingredient.setRecipeId(rs.getInt("userId"));
                ingredient.setRecipeId(rs.getInt("recipeId"));
                ingredient.setName_amount(rs.getString("name_amount"));

                return ingredient;
            }
        } catch (Exception e) {
            System.out.println("Can't find the ingredient's id!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteIngredient(int ingredientId) {
        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("DELETE FROM ingredient WHERE id = ?;")
        ) {

            pst.setInt(1, ingredientId);

            return pst.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't delete the ingredient!");
            return false;
        }
    }
}
