package org.launchcode.andrewgroupa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("list")
public class ListController {

    private static List<String> myList = new ArrayList<>();

    @GetMapping
    public String displayListAndAddForm(Model model) {
        model.addAttribute("title", "My List");
        model.addAttribute("myList", myList);
        return "list/index";
    }

    @PostMapping
    public String processAddForm(@RequestParam String itemName) {
        myList.add(itemName);
        return "redirect:/list";
    }


}
