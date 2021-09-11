package org.launchcode.andrewgroupa.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingList extends AbstractEntity{

    @NotBlank
    @Size(min = 3, max = 30, message = "List name but be between 3 and 30 characters.")
    private String name;

    private Integer listOwner;

    @OneToMany(mappedBy = "shoppingList")
    private final List<Item> items = new ArrayList<>();

    public ShoppingList() {}

    public ShoppingList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getListOwner() {
        return listOwner;
    }

    public void setListOwner(Integer listOwner) {
        this.listOwner = listOwner;
    }

    public List<Item> getItems() {
        return items;
    }
}
