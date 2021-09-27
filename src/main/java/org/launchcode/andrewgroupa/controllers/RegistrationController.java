package org.launchcode.andrewgroupa.controllers;

import javax.validation.Valid;
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

@Controller
@RequestMapping("register")
public class RegistrationController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @GetMapping
  public String displayRegistrationForm() {
    return "registration";
  }

  @PostMapping
  public String finishRegistration(@ModelAttribute @Valid User newUser, Errors errors,
      Model model) {

    if (errors.hasErrors()) {
      return "/registration?error";
    }

    try {
      newUser.setRoles("USER");
      newUser.setActive(true);
      userRepository.save(newUser);
      return "redirect:/login";
    } catch (Exception e) {
      System.out.println("Caught" + e.getMessage());
      return "redirect:/register?error";
    }

  }

}
