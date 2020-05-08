package com.vluv.recipe_hoarder_core.DAO;

import com.vluv.recipe_hoarder_core.model.User;

import java.util.List;

public interface UserDAO {

    boolean addUser(User u);
    public User getUserById(int id);
    User login(String mail, String password);
}
