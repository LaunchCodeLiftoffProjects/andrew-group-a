package org.launchcode.andrewgroupa.controllers;

import org.launchcode.andrewgroupa.data.ItemRepository;
import org.launchcode.andrewgroupa.data.TagRepository;
import org.launchcode.andrewgroupa.models.Item;
import org.launchcode.andrewgroupa.models.Tag;
import org.launchcode.andrewgroupa.models.dto.ItemTagDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
  private TagRepository tagRepository;

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

  @GetMapping("add-tag")
  public String displayAddTagForm(@RequestParam Integer itemId,Model model){
    Optional<Item> result = itemRepository.findById(itemId);
    Item item= result.get();
    model.addAttribute("title","Add tag to : " + item.getName() );
    model.addAttribute("tags",tagRepository.findAll());
    ItemTagDTO itemTag = new ItemTagDTO();
    itemTag.setItem(item);
    model.addAttribute("eventTag",new ItemTagDTO());
    return "list/add-tag.html";
  }

  @PostMapping("add-tag")
  public String processAddTagForm(@ModelAttribute @Valid ItemTagDTO itemTag,Errors errors,Model model){

    if(!errors.hasErrors()){
      Item item= itemTag.getItem();
      Tag tag = itemTag.getTag();
      if(!item.getTags().contains(tag)){
        item.addTag(tag);
        itemRepository.save(item);
      }
      return "redirect:list?itemId= " + item.getId();
    }

    return "redirect:add-tag";
  }


}


