package org.launchcode.andrewgroupa.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class ShoppingList extends AbstractEntity {

  @OneToMany(mappedBy = "shoppingList")
  private final List<Item> items = new ArrayList<>();
  @NotBlank
  @Size(min = 3, max = 30, message = "List name but be between 3 and 30 characters.")
  private String name;
  @ManyToOne
  private User listOwner;

  public ShoppingList() {
  }

  public ShoppingList(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User getListOwner() {
    return listOwner;
  }

  public void setListOwner(User listOwner) {
    this.listOwner = listOwner;
  }

  public List<Item> getItems() {
    return items;
  }
}
