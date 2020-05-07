package com.vluv.recipe_hoarder_core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table( name = "MENU" )
public class Menu implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private String title;
    @OneToMany(mappedBy = "menuId")
    private List<Recipe> menuRecipes;
    //összido is kellene meg

    public Menu() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
