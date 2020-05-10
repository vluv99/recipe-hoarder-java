package com.vluv;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    private Stage mainWindow;
    private Scene loginStage, recipesStage;

    @Override
    public void start(Stage primaryStage) {
        mainWindow = primaryStage;

        VBox root = new VBox();

        MenuBar menuBar = new MenuBar();    //menu content
        Menu recipesMenu = new Menu("Recipes");
        Menu logOutMenu = new Menu("Log Out");
        Menu logInMenu = new Menu("Log In");
        menuBar.getMenus().add(recipesMenu);
        menuBar.getMenus().add(logOutMenu);
        menuBar.getMenus().add(logInMenu);

        /*Button exit = new Button("Exit"); //exit button..?
        exit.setOnAction(e -> {

            Platform.exit();
        });*/

        constructLoginScene();
        constructScene2();


        root.getChildren().addAll(menuBar);



        //var label = new Label("Welcome to the Recipe-hoarder program!");
        //var scene = new Scene(root, 640, 480);
        mainWindow.setScene(loginStage);
        mainWindow.setTitle("Recipe-hoarder");
        mainWindow.show();
    }

    private void constructLoginScene() {

        Label lb = new Label("Scene 1");
        Button btn = new Button("Go to Scene 2");
        btn.setOnAction(e -> {
            mainWindow.setScene(recipesStage);
        });

        //Some layout
        VBox root = new VBox();
        root.getChildren().addAll(lb, btn);

        loginStage = new Scene(root, 300, 300);
    }

    private void constructScene2() {
        Label lb = new Label("Scene 2");
        Button btn = new Button("Go to Scene 1");
        btn.setOnAction(e -> {
            mainWindow.setScene(loginStage);
        });

        //Some layout
        VBox root = new VBox();
        root.getChildren().addAll(lb, btn);

        recipesStage = new Scene(root, 300, 300);
    }

    public static void main(String[] args) {
        launch();
    }

}