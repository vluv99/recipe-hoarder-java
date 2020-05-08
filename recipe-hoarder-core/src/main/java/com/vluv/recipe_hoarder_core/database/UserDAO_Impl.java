package com.vluv.recipe_hoarder_core.database;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.vluv.recipe_hoarder_core.DAO.UserDAO;
import com.vluv.recipe_hoarder_core.model.User;

import javax.persistence.EntityManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO_Impl implements UserDAO {
    //private EntityManager entityManager;

    private static final String ADD_USER = "INSERT INTO user (name, password, mail, address) VALUES (?,?,?,?)";
    private static final String GET_USER_BY_MAIL = "SELECT * FROM user WHERE mail = ?;";

    public UserDAO_Impl(EntityManager entityManager) {
        //this.entityManager = entityManager;
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

        List<User> users = new ArrayList<User>();

        try (
                Connection c = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                PreparedStatement pst = c.prepareStatement(GET_USER_BY_MAIL)
        ) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setMail(rs.getString("mail"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
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
             PreparedStatement pst = conn.prepareStatement("SELECT * FROM User WHERE mail = ?")
        ) {
            pst.setString(1, mail);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                String dbPass = rs.getString("password");

                BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), dbPass);
                if(result.verified){
                    User user = new User();
                    user.setMail(rs.getString("mail"));
                    user.setPassword(rs.getString("password"));
                    user.setName(rs.getString("name"));
                    user.setAddress(rs.getString("address"));
                    return user;
                }
            }
        } catch (SQLException e) {
            System.out.println("Login failed!");
            e.printStackTrace();
        }
        return null;
    }

}
