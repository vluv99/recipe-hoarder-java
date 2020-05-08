package com.vluv.recipe_hoarder_core.database;

import com.vluv.recipe_hoarder_core.DAO.RecipeDAO;
import com.vluv.recipe_hoarder_core.model.Recipe;
import com.vluv.recipe_hoarder_core.model.User;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO_Impl implements RecipeDAO {
    //private EntityManager entityManager;
    private boolean resultBool = false;

    public RecipeDAO_Impl(EntityManager entityManager) {
        //this.entityManager = entityManager;
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("INSERT INTO recipe (userId, menuId, name, description, cathegory) VALUES (?,?,?,?,?)")
        ) {

            pst.setInt(1, recipe.getUserId());
            pst.setInt(2, recipe.getMenuId());
            pst.setString(3, recipe.getName());
            pst.setString(4, recipe.getDescription());
            pst.setString(5, recipe.getCathegory());

            resultBool = pst.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't add the recipe!");
            return false;
        }

        if (resultBool){
            //add directions, add ingredients
        }
    }

    @Override
    public List<Recipe> getRecipesOfUser(int userId) {

        List<Recipe> recipes = new ArrayList<Recipe>();

        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("SELECT * FROM recipe WHERE userId = ?;")
        ) {

            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Recipe recipe = new Recipe();
                recipe.setId(rs.getInt("id"));
                recipe.setUserId(rs.getInt("userId"));
                recipe.setMenuId(rs.getInt("menuId"));
                recipe.setName(rs.getString("name"));
                recipe.setDescription(rs.getString("description"));
                recipe.setCathegory(rs.getString("cathegory"));

                recipes.add(recipe);
            }
            return recipes;
        } catch (Exception e) {
            System.out.println("Can't find the user's recipes!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Recipe> getRecipesOfMenu(int menuId){
        List<Recipe> recipes = new ArrayList<Recipe>();

        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("SELECT * FROM recipe WHERE menuId = ?;")
        ) {

            pst.setInt(1, menuId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Recipe recipe = new Recipe();
                recipe.setId(rs.getInt("id"));
                recipe.setUserId(rs.getInt("userId"));
                recipe.setMenuId(rs.getInt("menuId"));
                recipe.setName(rs.getString("name"));
                recipe.setDescription(rs.getString("description"));
                recipe.setCathegory(rs.getString("cathegory"));

                recipes.add(recipe);
            }
            return recipes;
        } catch (Exception e) {
            System.out.println("Can't find the menu's recipes!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Recipe getRecipe(int id) {
        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("SELECT * FROM recipe WHERE id = ?;")
        ) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Recipe recipe = new Recipe();
                recipe.setId(rs.getInt("id"));
                recipe.setUserId(rs.getInt("userId"));
                recipe.setMenuId(rs.getInt("menuId"));
                recipe.setName(rs.getString("name"));
                recipe.setDescription(rs.getString("description"));
                recipe.setCathegory(rs.getString("cathegory"));

                return recipe;
            }
        } catch (Exception e) {
            System.out.println("Can't find the recipe's id!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteRecipe(int recipeId) {
        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("DELETE FROM recipe WHERE id = ?;")
        ) {

            pst.setInt(1, recipeId);

            return pst.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't delete the recipe!");
            return false;
        }
    }

    @Override
    public boolean deleteRecipeFromMenu(int menuId) {
        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("DELETE FROM recipe WHERE menuId = ?;")
        ) {

            pst.setInt(1, menuId);

            return pst.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't delete the recipe from menu!");
            return false;
        }
    }
}
