package org.launchcode.andrewgroupa.controllers;

import org.launchcode.andrewgroupa.data.ItemRepository;
import org.launchcode.andrewgroupa.data.ShoppingListRepository;
import org.launchcode.andrewgroupa.data.UserRepository;
import org.launchcode.andrewgroupa.models.Item;
import org.launchcode.andrewgroupa.models.MyUserDetails;
import org.launchcode.andrewgroupa.models.ShoppingList;
import org.launchcode.andrewgroupa.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.JMoleculesConverters;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("list")
public class ListController {

  @Autowired
  private ItemRepository itemRepository;

  @Autowired
  private ShoppingListRepository shoppingListRepository;

  @Autowired
  private UserRepository userRepository;

  @GetMapping
  public String displayListAndAddItemForm(Model model) {
    model.addAttribute("title", "My List");
    model.addAttribute(new Item());
    model.addAttribute("myList", itemRepository.findAll());
    return "list/index";
  }

  @PostMapping
  public String processAddItemForm(@ModelAttribute @Valid Item newItem,
                                   Errors errors, Model model) {
    if (errors.hasErrors()) {
      model.addAttribute("title", "My List");
      return "list/index";
    }

    itemRepository.save(newItem);
    return "redirect:/list";
  }

  @GetMapping("shopping")
  public String displayListsAndAddListForm(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
    String currentUser = userDetails.getUsername();
    Optional<User> optActiveUser = userRepository.findByUsername(currentUser);
    User activeUser = optActiveUser.get();
    model.addAttribute("title", "Shopping Lists");
    model.addAttribute(new Item());
    model.addAttribute(new ShoppingList());
    model.addAttribute("myList", itemRepository.findAll());
    model.addAttribute("shoppingLists", activeUser.getShoppingLists());
    return "list/lists";
  }

  @PostMapping("shopping")
  public String processAddListForm(@ModelAttribute @Valid ShoppingList newShoppingList,
                                   @AuthenticationPrincipal MyUserDetails userDetails,
                                   Errors errors, Model model) {
    if (errors.hasErrors()) {
      model.addAttribute("title", "Shopping Lists");
      model.addAttribute(new Item());
      model.addAttribute(new ShoppingList());
      model.addAttribute("myList", itemRepository.findAll());
      model.addAttribute("shoppingLists", shoppingListRepository.findAll());
      return "list/lists";
    }
    String currentUser = userDetails.getUsername();
    Optional<User> optActiveUser = userRepository.findByUsername(currentUser);
    User activeUser = optActiveUser.get();
    newShoppingList.setListOwner(activeUser);
    shoppingListRepository.save(newShoppingList);

    return "redirect:/list/shopping";
  }

  @GetMapping("detail")
  public String displayListDetails(@RequestParam Integer listId, Model model) {
    ShoppingList currentList = shoppingListRepository.findById(listId).get();
    model.addAttribute(new Item());
    model.addAttribute("currentList", currentList);
    model.addAttribute("items", currentList.getItems());

    return "list/detail";
  }

  @PostMapping("detail")
  public String processItemAdditionToList(@RequestParam Integer listId, @ModelAttribute @Valid Item newItem,
                                   Errors errors, Model model) {
    if (errors.hasErrors()) {
      ShoppingList currentList = shoppingListRepository.findById(listId).get();
      model.addAttribute("currentList", currentList);
      model.addAttribute("items", currentList.getItems());
      return "list/detail";
    }

    ShoppingList currentList = shoppingListRepository.findById(listId).get();
    newItem.setShoppingList(currentList);
    itemRepository.save(newItem);
    return "redirect:detail?listId=" +listId;
  }
}