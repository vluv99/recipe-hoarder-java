package com.vluv.recipe_hoarder_core.model;

import java.io.Serializable;
import java.util.List;

public class Direction implements Serializable {
    private Integer id;
    private Integer recipeId;
    private int orderNumber;
    private List<String> direction;

    public Direction() {
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

    public List<String> getDirection() {
        return direction;
    }

    public void setDirection(List<String> direction) {
        this.direction = direction;
    }
}
