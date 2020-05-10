package com.vluv.GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try {
            GridPane root = new GridPane();
            root.setVgap(10); //függőleges helyköz a cellák között
            root.setHgap(30); //vízszintes helyköz a cellák között

            //első sor hozzáadása
            Text name = new Text("Név:");
            root.add(name, 0, 0); //add(Node child, int columnIndex, int rowIndex)
            TextField nameTextField = new TextField();
            root.add(nameTextField, 1, 0);

            //második sor hozzáadása
            Text email = new Text("Email:");
            root.add(email, 0, 1);
            TextField emailTextField = new TextField();
            root.add(emailTextField, 1, 1);

            // A két gombot belerakjuk egy HBox-ba
            Button ok = new Button("Ok");
            Button cancel = new Button("Mégse");
            HBox hb = new HBox();
            hb.setAlignment(Pos.CENTER); // A hbox-on belül középre igazítottak az elemek
            hb.setSpacing(20); // az elemek közötti távolság
            hb.getChildren().addAll(ok, cancel); // gombok a hbox-hoz
            root.add(hb, 0, 2, 2, 1); //hbox a grid-hez -> add(Node child, int columnIndex, int rowIndex, int colspan, int rowspan)

            root.setPadding(new Insets(10, 10, 10, 10)); // gridre egy padding
            Scene scene = new Scene(root, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
