package org.launchcode.andrewgroupa.models.dto;

import org.launchcode.andrewgroupa.models.Item;
import org.launchcode.andrewgroupa.models.Tag;

import javax.validation.constraints.NotNull;

public class EditItemDTO {

  @NotNull
  private Item item;

  private Tag tag;

  public EditItemDTO() {
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public Tag getTag() {
    return tag;
  }

  public void setTag(Tag tag) {
    this.tag = tag;
  }

}
