package com.vluv.recipe_hoarder_core.database;

import com.vluv.recipe_hoarder_core.DAO.MenuDAO;
import com.vluv.recipe_hoarder_core.model.Menu;
import com.vluv.recipe_hoarder_core.model.Recipe;
import com.vluv.recipe_hoarder_core.model.User;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO_Impl implements MenuDAO {
    //private EntityManager entityManager;

    public MenuDAO_Impl(EntityManager entityManager) {
        //this.entityManager = entityManager;
    }

    @Override
    public boolean AddMenu(Menu menu) {
        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement("INSERT INTO menu (userId, title) VALUES (?,?)")
        ) {

            pst.setInt(1, menu.getUserId());
            pst.setString(2, menu.getTitle());

            return pst.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't add the menu!");
            return false;
        }
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
                PreparedStatement pst = c.prepareStatement("SELECT * FROM menu WHERE userId = ?;")
        ) {

            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Menu menu = new Menu();
                menu.setId(rs.getInt("id"));
                menu.setUserId(rs.getInt("userId"));
                menu.setTitle(rs.getString("title"));

                menus.add(menu);
            }
            return menus;
        } catch (Exception e) {
            System.out.println("Can't find the user's menu!");
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
