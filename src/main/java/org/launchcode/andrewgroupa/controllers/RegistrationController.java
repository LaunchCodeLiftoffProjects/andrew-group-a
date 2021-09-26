package org.launchcode.andrewgroupa.controllers;

import org.launchcode.andrewgroupa.data.UserRepository;
import org.launchcode.andrewgroupa.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("register")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String displayRegistrationForm (){
        return "registration";
    }

    @PostMapping
    public String finishRegistration(@ModelAttribute @Valid User newUser, Errors errors, Model model){
        if (errors.hasErrors()) {
            return "/registration?error";
        }

        newUser.setRoles("USER");
        newUser.setActive(true);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.save(newUser);
        return "redirect:/login";
    }

}
