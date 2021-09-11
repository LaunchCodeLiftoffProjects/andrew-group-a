package org.launchcode.andrewgroupa.models;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Item extends AbstractEntity {

    @NotBlank
    @Size(min = 3, max = 20, message = "Item name but be between 3 and 20 characters.")
    private String name;

    @ManyToOne
    @NotNull(message = "List is required")
    private ShoppingList shoppingList;

    public Item() {}

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }
}
