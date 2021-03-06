package recipe_hoarder_core.model;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
import java.io.Serializable;

//@Entity
//@Table( name = "INGREDIENTS" )
public class Ingredient implements Serializable {
    //@Id
    //@GeneratedValue
    private Integer id;
    private Integer recipeId;
    private String name_amount;

    public Ingredient() {
    }

    public Ingredient(Integer recipeId, String name_amount) {
        this.recipeId = recipeId;
        this.name_amount = name_amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_amount() {
        return name_amount;
    }

    public void setName_amount(String name_amount) {
        this.name_amount = name_amount;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }
}
