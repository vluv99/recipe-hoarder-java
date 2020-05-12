package recipe_hoarder_core.model;

//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import java.io.Serializable;

public class ShoppingList_Item implements Serializable {
    //@Id
    //@GeneratedValue
    private Integer id;
    private Integer userId;
    private String name_amount;

    public ShoppingList_Item() {
    }

    public ShoppingList_Item(Integer userId, String name_amount) {
        this.userId = userId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
