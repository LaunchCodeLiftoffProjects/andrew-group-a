package org.launchcode.andrewgroupa.models;


import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Item extends AbstractEntity {

    @NotBlank
    @Size(min = 3, max = 255, message = "Item name but be between 3 and 250 characters.")
    private String name;

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

}
