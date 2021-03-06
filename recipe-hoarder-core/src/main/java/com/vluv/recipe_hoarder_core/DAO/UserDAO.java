package com.vluv.recipe_hoarder_core.DAO;

import com.vluv.recipe_hoarder_core.model.Ingredient;
import com.vluv.recipe_hoarder_core.model.ShoppingList_Item;
import com.vluv.recipe_hoarder_core.model.User;

import java.util.List;

public interface UserDAO {

    boolean addUser(User u);
    public User getUserById(int id);
    User login(String mail, String password);
    boolean addShoppingListIngredient(ShoppingList_Item i);
    List<ShoppingList_Item> getShoppingListIngredients(User u);
    boolean deleteShoppingListIngredient(int id);
}
