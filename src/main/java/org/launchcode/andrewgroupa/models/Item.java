package org.launchcode.andrewgroupa.models;


import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Item extends AbstractEntity {

    @NotNull
    @Size(min = 3, max = 255, message = "Item name but be between 3 and 250 characters.")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
