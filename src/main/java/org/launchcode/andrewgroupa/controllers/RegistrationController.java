package org.launchcode.andrewgroupa.controllers;

import org.hibernate.NonUniqueObjectException;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.launchcode.andrewgroupa.Exceptions.DuplicateException;
import org.launchcode.andrewgroupa.Exceptions.DuplicateUser;
import org.launchcode.andrewgroupa.data.UserRepository;
import org.launchcode.andrewgroupa.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("register")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String displayRegistrationForm (){
        return "registration";
    }

    @PostMapping
    public String finishRegistration(@ModelAttribute @Valid User newUser, Errors errors, Model model){

        if (errors.hasErrors()) {
            return "/registration?error";
        }


        try {
            newUser.setRoles("USER");
            newUser.setActive(true);
            userRepository.save(newUser);
            return "redirect:/login";
        } catch (Exception e){
            System.out.println("Caught" + e.getMessage());
            return "redirect:/register?error";
        }

    }

}
