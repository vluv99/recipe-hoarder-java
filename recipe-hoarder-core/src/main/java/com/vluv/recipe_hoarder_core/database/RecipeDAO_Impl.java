package com.vluv.recipe_hoarder_core.database;

import com.vluv.recipe_hoarder_core.DAO.RecipeDAO;
import com.vluv.recipe_hoarder_core.model.Direction;
import com.vluv.recipe_hoarder_core.model.Ingredient;
import com.vluv.recipe_hoarder_core.model.Recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO_Impl implements RecipeDAO {
    //private EntityManager entityManager;

    public RecipeDAO_Impl() {
        //this.entityManager = entityManager;
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        boolean resultBool = false;

        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("INSERT INTO Recipe (userId, name, description, cathegory) VALUES (?,?,?,?)")
        ) {

            pst.setInt(1, recipe.getUserId());
            pst.setString(2, recipe.getName());
            pst.setString(3, recipe.getDescription());
            pst.setString(4, recipe.getCathegory());

            resultBool = pst.executeUpdate() == 1;

            //Load the generated id
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                recipe.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("ERROR: Creating user failed, no ID obtained.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: Can't add the recipe!");
            return false;
        }

        if (resultBool) {
            //add directions, add ingredients
            for (Direction d : recipe.getDirections()) {
                boolean res = addRecipeDirection(recipe, d);
                if (!res) {
                    System.out.println("ERROR: Can't save directions");
                    return false;
                }
            }

            for (Ingredient d : recipe.getIngredients()) {
                boolean res = addRecipeIngredient(recipe, d);
                if (!res) {
                    System.out.println("ERROR: Can't save ingredients");
                    return false;
                }
            }

        }

        return resultBool;
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
                Recipe recipe = loadRecipe(rs);

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
    public Recipe getRecipe(int id) {
        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("SELECT * FROM recipe WHERE id = ?;")
        ) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Recipe recipe = loadRecipe(rs);


                return recipe;
            }
        } catch (Exception e) {
            System.out.println("Can't find the recipe's id!");
            e.printStackTrace();
        }
        return null;
    }


    private boolean addRecipeDirection(Recipe r, Direction d) {
        boolean resultBool = false;

        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("INSERT INTO Recipe_Directions (recipeId, orderNumber, direction) VALUES (?,?,?)")
        ) {

            pst.setInt(1, r.getId());
            pst.setInt(2, d.getOrderNumber());
            pst.setString(3, d.getDirection());

            resultBool = pst.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't add the recipe!");

        }

        return resultBool;
    }

    private boolean addRecipeIngredient(Recipe r, Ingredient d) {
        boolean resultBool = false;

        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("INSERT INTO Recipe_Ingredients (recipeId, name_amount) VALUES (?,?)")
        ) {

            pst.setInt(1, r.getId());
            pst.setString(2, d.getName_amount());

            resultBool = pst.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't add the recipe!");

        }

        return resultBool;
    }


    private Recipe loadRecipe(ResultSet rs) throws SQLException {
        Recipe recipe = new Recipe();
        recipe.setId(rs.getInt("id"));
        recipe.setUserId(rs.getInt("userId"));
        recipe.setName(rs.getString("name"));
        recipe.setDescription(rs.getString("description"));
        recipe.setCathegory(rs.getString("cathegory"));

        //TODO: Load the ingredients of the recipe
        loadDirections(recipe);
        loadIngredients(recipe);

        return recipe;
    }

    private boolean loadDirections(Recipe r) {
        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("SELECT * FROM Recipe_Directions WHERE recipeId = ? ORDER BY orderNumber;")
        ) {

            pst.setInt(1, r.getId());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Direction d = new Direction();
                d.setId(rs.getInt("id"));
                d.setRecipeId(rs.getInt("recipeId"));
                d.setOrderNumber(rs.getInt("orderNumber"));
                d.setDirection(rs.getString("direction"));
                r.getDirections().add(d);
            }
        } catch (Exception e) {
            System.out.println("ERROR: Can't load the recipe's directions!");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private boolean loadIngredients(Recipe r) {
        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("SELECT * FROM Recipe_Ingredients WHERE recipeId = ?;")
        ) {

            pst.setInt(1, r.getId());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Ingredient d = new Ingredient();
                d.setId(rs.getInt("id"));
                d.setRecipeId(rs.getInt("recipeId"));
                d.setName_amount(rs.getString("name_amount"));
                r.getIngredients().add(d);
            }
        } catch (Exception e) {
            System.out.println("ERROR: Can't load the recipe's ingredients!");
            e.printStackTrace();
            return false;
        }

        return true;
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


/*
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
*/


/*
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
    */

}
