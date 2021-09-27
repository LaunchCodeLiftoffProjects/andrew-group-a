package org.launchcode.andrewgroupa.models;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AbstractEntity {

  @OneToMany(mappedBy = "listOwner")
  private final List<ShoppingList> shoppingLists = new ArrayList<>();
  @NotNull
  @NotBlank
  @Column(unique = true)
  private String username;
  @NotBlank
  @NotNull
  private String password;
  private boolean active;
  private String roles;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public String getRoles() {
    return roles;
  }

  public void setRoles(String roles) {
    this.roles = roles;
  }

  public List<ShoppingList> getShoppingLists() {
    return shoppingLists;
  }
}
