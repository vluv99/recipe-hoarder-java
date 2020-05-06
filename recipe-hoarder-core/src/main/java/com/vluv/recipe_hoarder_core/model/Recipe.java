package com.vluv.recipe_hoarder_core.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "RECIPE" )
public class Recipe {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<String> ingredients = new ArrayList<>();
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<String> directions = new ArrayList<>();
    private String cathegory;
    /*nehezseg
    * hany fore eleg
    * idotartam*/

    public Recipe() {
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

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getDirections() {
        return directions;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }

    public String getCathegory() {
        return cathegory;
    }

    public void setCathegory(String cathegory) {
        this.cathegory = cathegory;
    }
}
