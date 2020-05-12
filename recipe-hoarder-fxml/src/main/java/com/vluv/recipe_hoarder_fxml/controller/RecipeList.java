package com.vluv.recipe_hoarder_fxml.controller;

import com.vluv.recipe_hoarder_core.model.Recipe;
import com.vluv.recipe_hoarder_core.model.User;
import com.vluv.recipe_hoarder_fxml.Fragment;
import com.vluv.recipe_hoarder_fxml.Session;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.io.IOException;

public class RecipeList extends Fragment {

    @FXML
    ListView<Recipe> listView;

    @FXML
    public void initialize() {
        User u = Session.getInstace(null).getUser();
        if(listView != null) {

            listView.setCellFactory(new Callback<ListView<Recipe>, ListCell<Recipe>>() {
                @Override
                public ListCell call(ListView listView) {
                    return new RecipeListItem();
                }
            });



            for (Recipe r : u.getRecipeList()) {
                listView.getItems().add(r);
            }
        }

    }

    static class RecipeListItem extends ListCell<Recipe> {
        private HBox content;
        private Text name;
        private Text price;

        public RecipeListItem() {
            super();
            name = new Text();
            price = new Text();
            VBox vBox = new VBox(name, price);
            content = new HBox(vBox,new Label("[Graphic]"));
            content.setSpacing(10);
        }

        @Override
        public void updateItem(Recipe item, boolean empty) {
            super.updateItem(item, empty);
            Rectangle rect = new Rectangle(100, 20);
            if (item != null) {
                name.setText(item.getName());
                price.setText(item.getCathegory());
                setGraphic(content);
            }
        }
    }

    @FXML
    public void recipeClicked(MouseEvent click) throws IOException {

        if (click.getClickCount() == 2) {
            //Use ListView's getSelected Item
            Recipe currentItemSelected = listView.getSelectionModel().getSelectedItem();

            System.out.println(currentItemSelected.getName());
            Session.getInstace(null).setRecipe(currentItemSelected);
            main.navigate(RecipeController.ID);
            //use this to do whatever you want to. Open Link etc.
        }
    }

}
