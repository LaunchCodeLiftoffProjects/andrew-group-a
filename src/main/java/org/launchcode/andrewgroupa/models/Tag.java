package org.launchcode.andrewgroupa.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Tag extends AbstractEntity {

  @ManyToMany(mappedBy = "tags")
  private final List<Item> items = new ArrayList<>();
  @Size(min = 1, max = 25)
  @NotBlank
  private String name;

  public Tag() {
  }

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

  public List<Item> getItems() {
    return items;
  }
}
