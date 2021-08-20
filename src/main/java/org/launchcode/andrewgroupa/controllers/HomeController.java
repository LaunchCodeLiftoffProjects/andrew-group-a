package org.launchcode.andrewgroupa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("")
    public String welcomeToLists() {
        return "index";
    }

    @GetMapping("login")
    public String login() { return "login"; }
}
