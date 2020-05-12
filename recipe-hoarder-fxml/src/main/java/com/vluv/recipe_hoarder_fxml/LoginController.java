package com.vluv.recipe_hoarder_fxml;

import com.vluv.recipe_hoarder_core.database.Database;
import com.vluv.recipe_hoarder_core.model.User;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    public TextField userName;
    public PasswordField password;

    public void loginButton() throws IOException {
        //TODO finish the login controller
        System.out.println("button clicked successfully!");
        String u = userName.getText();
        String p = password.getText();

        User user = Database.getInstance().getUserDAO().login(u,p);

        if(user == null){

        }
        else{
            App.setRoot("Secondary");
        }

    }
}
