package com.vluv;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class RecipeMenuController {

    @FXML
    private void logOut(MouseEvent event){
        System.out.println("user is logged out!");
    }

    @FXML
    private void goToRecipes(MouseEvent event){
        System.out.println("user wants to see the recipes!");
    }
}
