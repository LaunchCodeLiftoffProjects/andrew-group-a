package org.launchcode.andrewgroupa.controllers;

import org.launchcode.andrewgroupa.data.TagRepository;
import org.launchcode.andrewgroupa.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("tags")
public class TagController {

    @Autowired
    TagRepository tagRepository;

    @GetMapping
    public String displayTagAndAddTagForm(Model model){
        model.addAttribute("title","All Tags");
        model.addAttribute(new Tag());
        model.addAttribute("tags",tagRepository.findAll());
        return "tag/index";
    }

    @PostMapping
    public String processAddTagForm(@ModelAttribute @Valid Tag newTag,Errors errors,Model model)
    {
        if (errors.hasErrors())
        {
            model.addAttribute("title", "All Tags");
            return "tag/index";
        }

        tagRepository.save(newTag);
        return "redirect:/tags";
    }

}
