package org.launchcode.andrewgroupa.controllers;

import org.launchcode.andrewgroupa.data.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tags")
public class TagController {

    @Autowired
    TagRepository tagRepository;

    public String displayTag(Model model){
        model.addAttribute("title","All Tags");
        model.addAttribute("tags",tagRepository.findAll());
        return "tag/index";
    }
}
