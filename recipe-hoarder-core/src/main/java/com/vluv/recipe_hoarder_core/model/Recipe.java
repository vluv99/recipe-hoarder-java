package com.vluv.recipe_hoarder_core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "RECIPE" )
public class Recipe implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    //private Integer menuId;
    private String name;
    private String description;
    @OneToMany(mappedBy = "recipeId")
    private List<Ingredient> ingredients = new ArrayList<>();
    @ElementCollection
    private List<Direction> directions = new ArrayList<>();
    private String cathegory;
    /*nehezseg
    * hany fore eleg
    * idotartam*/

    public Recipe() {
    }

    public Recipe(Integer userId, String name, String description, String cathegory) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.cathegory = cathegory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Direction> getDirections() {
        return directions;
    }

    public void setDirections(List<Direction> directions) {
        this.directions = directions;
    }

    public String getCathegory() {
        return cathegory;
    }

    public void setCathegory(String cathegory) {
        this.cathegory = cathegory;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
/*
    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

 */
}
