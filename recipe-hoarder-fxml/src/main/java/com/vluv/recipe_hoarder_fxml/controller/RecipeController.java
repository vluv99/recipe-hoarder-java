package com.vluv.recipe_hoarder_fxml.controller;

import com.vluv.recipe_hoarder_core.model.Direction;
import com.vluv.recipe_hoarder_core.model.Ingredient;
import com.vluv.recipe_hoarder_core.model.Recipe;
import com.vluv.recipe_hoarder_core.model.User;
import com.vluv.recipe_hoarder_fxml.Fragment;
import com.vluv.recipe_hoarder_fxml.Session;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class RecipeController extends Fragment {

    public static final String ID = "Recipe";

    @FXML
    public Label name;

    @FXML
    public Text description;

    @FXML
    public ListView<Ingredient> ingredients;

    @FXML
    public ListView<Direction> directions;


    @FXML
    public void initialize() {
        Recipe recipe = Session.getInstace(null).getRecipe();
        if(recipe == null){
            return;
        }

        name.setText(recipe.getName());
        description.setText(recipe.getDescription());


        ingredients.getItems().addAll(recipe.getIngredients());
        ingredients.setCellFactory(new Callback<ListView<Ingredient>, ListCell<Ingredient>>() {
            @Override
            public ListCell<Ingredient> call(ListView<Ingredient> ingredientListView) {
                return new IngredientListItem();
            }
        });
        directions.getItems().addAll(recipe.getDirections());
        directions.setCellFactory(new Callback<ListView<Direction>, ListCell<Direction>>() {
            @Override
            public ListCell<Direction> call(ListView<Direction> directionListView) {
                return new DirectionListItem();
            }
        });

    }

    static class IngredientListItem extends ListCell<Ingredient> {
        //private HBox content;
        private Text name;
        //private Text number;

        public IngredientListItem() {
            super();
            name = new Text();
            //number = new Text();
            //content = new HBox(name, number);
            //content.setSpacing(10);
        }

        @Override
        public void updateItem(Ingredient item, boolean empty) {
            super.updateItem(item, empty);
            Rectangle rect = new Rectangle(100, 20);
            if (item != null) {
                name.setText(item.getName_amount());
                //number.setText(item.getCathegory());
                setGraphic(name);
            }
        }
    }

    static class DirectionListItem extends ListCell<Direction> {
        private HBox content;
        private Text name;
        private Text number;

        public DirectionListItem() {
            super();
            name = new Text();
            number = new Text();
            content = new HBox(number, name);
            content.setSpacing(10);
        }

        @Override
        public void updateItem(Direction item, boolean empty) {
            super.updateItem(item, empty);
            Rectangle rect = new Rectangle(100, 20);
            if (item != null) {
                name.setText(item.getDirection());
                int num = item.getOrderNumber();
                number.setText(String.valueOf(num));
                setGraphic(content);
            }
        }
    }

}
