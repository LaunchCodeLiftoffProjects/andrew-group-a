package org.launchcode.andrewgroupa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("")
    public String welcomeToLists() {
        return "index";
    }

    @RequestMapping(value="login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login() { return "login"; }
}
