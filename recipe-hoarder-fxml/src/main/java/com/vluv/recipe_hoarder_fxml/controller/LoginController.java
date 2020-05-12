package com.vluv.recipe_hoarder_fxml.controller;

import com.vluv.recipe_hoarder_core.database.Database;
import com.vluv.recipe_hoarder_core.model.User;
import com.vluv.recipe_hoarder_fxml.Activity;
import com.vluv.recipe_hoarder_fxml.App;
import com.vluv.recipe_hoarder_fxml.Session;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController extends Activity {

    public TextField userName;
    public PasswordField password;

    public void loginButton() throws IOException {
        //TODO finish the login controller
        System.out.println("button clicked successfully!");
        String u = userName.getText();
        String p = password.getText();

        User user = Database.getInstance().getUserDAO().login(u,p);

        if(user == null){
            System.out.println("Bad login!");
        }
        else{
            Session.getInstace(user);

            App.setRoot("MainMenu");
        }

    }
}
