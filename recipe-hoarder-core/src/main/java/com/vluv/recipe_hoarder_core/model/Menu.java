package com.vluv.recipe_hoarder_core.model;

import java.util.List;

public class Menu {
    private String id;
    private String title;
    private List<Recipe> menuRecipes;
    //összido is kellene meg


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Recipe> getMenuRecipes() {
        return menuRecipes;
    }

    public void setMenuRecipes(List<Recipe> menuRecipes) {
        this.menuRecipes = menuRecipes;
    }
}
