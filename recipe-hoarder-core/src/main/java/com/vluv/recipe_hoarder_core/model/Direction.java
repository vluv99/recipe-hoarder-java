package com.vluv.recipe_hoarder_core.model;

import java.io.Serializable;
import java.util.List;

public class Direction implements Serializable {
    private Integer id;
    private Integer recipeId;
    private int orderNumber;
    private String direction;

    public Direction() {
    }

    public Direction(Integer recipeId, int orderNumber, String direction) {
        this.recipeId = recipeId;
        this.orderNumber = orderNumber;
        this.direction = direction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
