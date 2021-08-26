package org.launchcode.andrewgroupa.models;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item extends AbstractEntity {

    @NotBlank
    @Size(min = 3, max = 20, message = "Item name but be between 3 and 20 characters.")
    private String name;

    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();

    public Item() {}

    //getter setter and set name for list name
    public Item(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //getter and add method for tag
    public List<Tag> getTags() {
        return tags;
    }
    public void addTag(Tag tag){
        this.tags.add(tag);
    }
}
