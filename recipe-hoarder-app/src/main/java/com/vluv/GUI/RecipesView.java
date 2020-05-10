package com.vluv.GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RecipesView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Recipe-hoarder");

        TilePane root = new TilePane();
        root.setPadding(new Insets(10));
        root.setVgap(10);
        root.setHgap(10);

        Button btn1 = new Button("1");
        btn1.setPrefWidth(20);

        Button btn2 = new Button("2");
        btn2.setPrefWidth(20);

        Button btn3 = new Button("3");
        btn3.setPrefWidth(20);

        root.getChildren().addAll(btn1, btn2, btn3);

        Scene scene = new Scene(root, 300, 50);

        stage.setScene(scene);
        stage.show();
    }
}
