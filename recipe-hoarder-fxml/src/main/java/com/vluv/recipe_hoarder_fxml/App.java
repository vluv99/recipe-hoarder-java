package com.vluv.recipe_hoarder_fxml;

import com.vluv.recipe_hoarder_core.database.Database;
import com.vluv.recipe_hoarder_core.model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Recipe-hoarder");

        Database a = com.vluv.recipe_hoarder_core.database.Database.getInstance();

        App.stage = stage;
        scene = new Scene(loadFXML("Login"));
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene = new Scene(loadFXML(fxml));
        stage.setScene(scene);
        stage.sizeToScene();
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent a = fxmlLoader.load();
        Activity controller = fxmlLoader.<Activity>getController();
        controller.setStage(stage);
        controller.Init();
        return a;
    }

    public static void main(String[] args) {
        launch();
    }

}