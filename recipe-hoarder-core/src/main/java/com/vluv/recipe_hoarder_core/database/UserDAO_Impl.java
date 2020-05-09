package com.vluv.recipe_hoarder_core.database;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.vluv.recipe_hoarder_core.DAO.UserDAO;
import com.vluv.recipe_hoarder_core.model.Ingredient;
import com.vluv.recipe_hoarder_core.model.Recipe;
import com.vluv.recipe_hoarder_core.model.ShoppingList_Item;
import com.vluv.recipe_hoarder_core.model.User;

import javax.persistence.EntityManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO_Impl implements UserDAO {

    private static final String ADD_USER = "INSERT INTO USER (name, password, mail, address) VALUES (?,?,?,?)";
    private static final String GET_USER_BY_MAIL = "SELECT * FROM USER WHERE mail = ?;";
    private static final String GET_USER_BY_ID = "SELECT * FROM USER WHERE id = ?;";

    public UserDAO_Impl() {
    }

    @Override
    public boolean addUser(User user) {
        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement(ADD_USER)
        ) {

            pst.setString(1, user.getName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getMail());
            pst.setString(4, user.getAddress());

            return pst.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't add the user!");
            return false;
        }
    }

    @Override
    public User getUserById(int id) {
        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement(GET_USER_BY_ID)
        ) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setMail(rs.getString("mail"));
                user.setAddress(rs.getString("address"));
                return user;
            }
        } catch (Exception e) {
            System.out.println("Can't find the user by id!");
            e.printStackTrace();
        }

        return null;
    }

    @Override //get user by email and login cryptig
    public User login(String mail, String password) {

        try (Connection conn = DriverManager.getConnection(DBConfig.DB_CONN_STR);
             PreparedStatement pst = conn.prepareStatement(GET_USER_BY_MAIL)
        ) {
            pst.setString(1, mail);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                String dbPass = rs.getString("password");

                //BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), dbPass);ű
                //if(result.verified){
                if (dbPass.equals(password)) {
                    return loadUser(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Login failed!");
            e.printStackTrace();
        }
        return null;
    }

    private User loadUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setMail(rs.getString("mail"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setAddress(rs.getString("address"));

        user.setShoppingList(getShoppingListIngredients(user));
        user.setMenuList(Database.getInstance().getMenuDAO().getMenusOfUser(user.getId())); //get menus of user
        user.setRecipeList(Database.getInstance().getRecipeDAO().getRecipesOfUser(user.getId())); //get recipes of user

        return user;
    }

    @Override
    public boolean addShoppingListIngredient(ShoppingList_Item i) {
        boolean resultBool = false;

        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("INSERT INTO ShoppingList_Ingredients (userId, name_amount) VALUES (?,?);")
        ) {

            pst.setInt(1, i.getUserId());
            pst.setString(2, i.getName_amount());


            resultBool = pst.executeUpdate() == 1;

            //Load the generated id
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                i.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("ERROR: Creating shoppingList ingredient failed, no ID obtained.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't add the shoppping list ingredient!");
            return false;
        }

        return true;
    }

    @Override
    public List<ShoppingList_Item> getShoppingListIngredients(User u) {
        List<ShoppingList_Item> shoppingList = new ArrayList<ShoppingList_Item>();

        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("SELECT * FROM ShoppingList_Ingredients WHERE userId = ?;")
        ) {

            pst.setInt(1, u.getId());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                ShoppingList_Item i = new ShoppingList_Item();
                i.setId(rs.getInt("id"));
                i.setUserId(rs.getInt("userId"));
                i.setName_amount(rs.getString("name_amount"));
                shoppingList.add(i);
            }
            return shoppingList;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't get the shoppping list ingredients!");
            return null;
        }
    }

    @Override
    public boolean deleteShoppingListIngredient(int id) {

        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("DELETE FROM ShoppingList_Ingredients WHERE id = ?;")
        ) {

            pst.setInt(1, id);

            return pst.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't delete the shoppping list ingredients!");
            return false;
        }
    }

}
