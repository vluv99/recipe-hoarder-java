package com.vluv.recipe_hoarder_core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table( name = "USER" )
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String password;
    private String mail;
    private String address;
    @OneToMany(mappedBy = "userId")
    private List<Recipe> recipeList;
    @OneToMany(mappedBy = "userId")
    private List<ShoppingList_Item> shoppingList;
    @OneToMany(mappedBy = "userId")
    private List<Menu> menuList;

    public User() {
    }

    public User(String name, String password, String mail, String address) {
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.address = address;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public List<ShoppingList_Item> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<ShoppingList_Item> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
