package com.vluv.recipe_hoarder_core.model;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Recipe implements Serializable {

    private Integer id;
    private Integer userId;
    //private Integer menuId;
    private String name;
    private String description;

    private List<Ingredient> ingredients = new ArrayList<>();

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


    public static Recipe fromScraperModel(com.aper_lab.scraperlib.data.Recipe r){
        Recipe res = new Recipe();
        res.name = r.getName();
        res.description = r.getDescription();
        for (com.aper_lab.scraperlib.data.Ingredient i : r.getIngredients()) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName_amount(i.getName());

            res.ingredients.add(ingredient);
        }
        for (com.aper_lab.scraperlib.data.RecipeStep s : r.getDirections()) {
            Direction d = new Direction();
            d.setOrderNumber(s.getNum());
            d.setDirection(s.getText());

            res.directions.add(d);
        }

        res.setCathegory("Miscellaneous");

        return res;
    }
}
