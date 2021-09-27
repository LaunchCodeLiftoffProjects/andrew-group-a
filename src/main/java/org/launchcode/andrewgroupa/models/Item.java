package org.launchcode.andrewgroupa.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item extends AbstractEntity {

  @ManyToMany
  private final List<Tag> tags = new ArrayList<>();
  @NotBlank
  @Size(min = 3, max = 20, message = "Item name but be between 3 and 20 characters.")
  @Column(unique = true)
  private String name;
  @ManyToOne
  private ShoppingList shoppingList;
  private int quantity;
  private boolean complete;

  public Item(String name, ShoppingList shoppingList) {
    this.name = name;
    this.shoppingList = shoppingList;
    this.quantity = 1;
    this.complete = false;
  }

  public Item() {
    this.quantity = 1;
    this.complete = false;
  }

  public Item(String name) {
    this.name = name;
  }

  public boolean isComplete() {
    return complete;
  }

  public void setComplete(boolean complete) {
    this.complete = complete;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
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

  public List<Tag> getTags() {
    return tags;
  }

  public void addTag(Tag tag) {
    this.tags.add(tag);
  }
}
