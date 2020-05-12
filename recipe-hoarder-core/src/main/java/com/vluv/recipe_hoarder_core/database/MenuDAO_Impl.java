package com.vluv.recipe_hoarder_core.database;

import com.vluv.recipe_hoarder_core.DAO.MenuDAO;
import com.vluv.recipe_hoarder_core.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO_Impl implements MenuDAO {

    public MenuDAO_Impl() {
    }

    @Override
    public boolean AddMenu(Menu menu) {
        boolean resultBool = false;

        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("INSERT INTO Menu (userId, title) VALUES (?,?)")
        ) {

            pst.setInt(1, menu.getUserId());
            pst.setString(2, menu.getTitle());

            resultBool = pst.executeUpdate() == 1;

            //Load the generated id
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                menu.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("ERROR: Creating user failed, no ID obtained.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: Can't add the menu!");
            return false;
        }

        return resultBool;
    }

    @Override
    public Menu getMenu(int id){
        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("SELECT * FROM menu WHERE id = ?;")
        ) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Menu menu = new Menu();
                menu.setId(rs.getInt("id"));
                menu.setUserId(rs.getInt("userId"));
                menu.setTitle(rs.getString("title"));

                return menu;
            }
        } catch (Exception e) {
            System.out.println("Can't find the menu's id!");
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Menu> getMenusOfUser(int userId){
        List<Menu> menus = new ArrayList<Menu>();

        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("SELECT * FROM Menu WHERE userId = ?;")
        ) {

            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Menu menu = new Menu();
                menu.setId(rs.getInt("id"));
                menu.setUserId(rs.getInt("userId"));
                menu.setTitle(rs.getString("title"));
                menu.setMenuRecipes(Database.getInstance().getRecipeDAO().getRecipesOfMenu(menu.getId()));

                menus.add(menu);
            }
            return menus;
        } catch (Exception e) {
            System.out.println("Can't find the user's menus!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteMenu(int menuId) {
        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("DELETE FROM menu WHERE id = ?;")
        ) {

            pst.setInt(1, menuId);

            return pst.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't delete the menu!");
            return false;
        }
    }


}
