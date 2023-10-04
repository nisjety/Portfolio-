package com.example.portfolio.web.controller;

import com.example.portfolio.api.model.User;
import com.example.portfolio.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User(Long id, String fullname, String username, String password, String email, int number));
        return "register";  // Corresponds to a Thymeleaf template for registration
    }

    @PostMapping("/register")
    public String handleRegistration(@ModelAttribute User user) {
        userService.register(user);
        return "redirect:/login";  // Redirect to login after successful registration
    }

    // ... more methods for login, profile view, etc.
}
