package com.vluv.recipe_hoarder_fxml;

import com.vluv.recipe_hoarder_core.model.Recipe;
import com.vluv.recipe_hoarder_core.model.User;

public final class Session {

    private static Session instance;

    private User user;
    private Recipe recipe;

    private Session(User u) {
        this.user = u;
    }

    public static Session getInstace(User u) {
        if(instance == null) {
            instance = new Session(u);
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public void cleanUserSession() {
        user = null;// or null
        instance = null;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "userName='" + user.getName() + '\'' +
                '}';
    }
}