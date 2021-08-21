package org.launchcode.andrewgroupa.controllers;

import org.launchcode.andrewgroupa.data.ItemRepository;
import org.launchcode.andrewgroupa.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("list")
public class ListController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public String displayListAndAddItemForm(Model model) {
        model.addAttribute("title", "My List");
        model.addAttribute(new Item());
        model.addAttribute("myList", itemRepository.findAll());
        return "list/index";
    }

    @PostMapping
    public String processAddItemForm(@RequestParam String itemName) {
        return "redirect:/list";
    }

//    @DeleteMapping
//    public String processDeleteItem() {
//        return "";
//    }

}