package com.vluv.recipe_hoarder_fxml.controller;

import com.vluv.recipe_hoarder_core.model.Recipe;
import com.vluv.recipe_hoarder_core.model.User;
import com.vluv.recipe_hoarder_fxml.Activity;
import com.vluv.recipe_hoarder_fxml.App;
import com.vluv.recipe_hoarder_fxml.Fragment;
import com.vluv.recipe_hoarder_fxml.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import java.io.IOException;

public class MainMenuController extends Activity {

    @FXML
    public BorderPane borderPane;

    @Override
    public void Init() throws IOException {
        navigate("RecipeList");
    }

    @FXML
    public void initialize() throws IOException {

    }

    @FXML
    private void logOut() throws IOException {
        Session.getInstace(null).cleanUserSession();
        System.out.println("user is logged out!");
        App.setRoot("Login");
    }

    @FXML
    private void goToRecipes() throws IOException {
        System.out.println("user wants to see the recipes!");
        if(borderPane == null){
            System.out.println("Wrong layout!");
        }
        else {
            borderPane.setCenter(loadFXML("RecipeList"));
        }
    }

    public void navigate(String target) throws IOException {
        borderPane.setCenter(loadFXML(target));
        stage.sizeToScene();
    }

    private Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent a = fxmlLoader.load();
        Fragment controller = fxmlLoader.<Fragment>getController();
        controller.setMain(this);
        return a;
    }
}
