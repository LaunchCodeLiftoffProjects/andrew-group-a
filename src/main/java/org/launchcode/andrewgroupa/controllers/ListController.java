package org.launchcode.andrewgroupa.controllers;

import org.launchcode.andrewgroupa.data.ItemRepository;
import org.launchcode.andrewgroupa.data.TagRepository;
import org.launchcode.andrewgroupa.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("list")
public class ListController {

  @Autowired
  private ItemRepository itemRepository;

  @Autowired
  TagRepository tagRepository;

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

}