package org.launchcode.andrewgroupa.models.dto;

import org.launchcode.andrewgroupa.models.Item;
import org.launchcode.andrewgroupa.models.Tag;

import javax.validation.constraints.NotNull;

public class ItemTagDTO {

    @NotNull
    private Item item;

    @NotNull
    private Tag tag;

    public ItemTagDTO(){}

    //getter and setter for item
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }


    //Getter and Setter for tag
    public Tag getTag() {
        return tag;
    }
    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
