package com.vluv.recipe_hoarder_core.database;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.vluv.recipe_hoarder_core.DAO.UserDAO;
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
    public User getUserById(int id){
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
        }
        catch (Exception e) {
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
                if(dbPass.equals(password)){
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

        user.setRecipeList(Database.getInstance().getRecipeDAO().getRecipesOfUser(user.getId()));

        return user;
    }

}
