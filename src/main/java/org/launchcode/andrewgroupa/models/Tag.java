package org.launchcode.andrewgroupa.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Tag extends AbstractEntity{

    @Size(min = 1, max = 25)
    @NotBlank
    private String name;

    public Tag(){}

    public Tag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return "#" + name + " ";
    }
}
