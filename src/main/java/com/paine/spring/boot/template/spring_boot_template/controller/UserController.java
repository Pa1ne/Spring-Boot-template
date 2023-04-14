package com.paine.spring.boot.template.spring_boot_template.controller;


import com.paine.spring.boot.template.spring_boot_template.services.UserService;
import com.paine.spring.boot.template.spring_boot_template.entity.User;

import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;


@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/addUser")
    public String addUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add_user";
    }

    @PostMapping("/")
    public String saveUser(@ModelAttribute("user") User user) {
        if (!user.getFirstName().isEmpty()
                && !user.getLastName().isEmpty()
                && !user.getCitizenship().isEmpty()) {
            userService.addOrEditUser(user);
            return "redirect:/";
        }
        return "add_user";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit_user";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user) {
        User UserFromDatabase = userService.getUserById(id);
        UserFromDatabase.setId(id);
        UserFromDatabase.setFirstName(user.getFirstName());
        UserFromDatabase.setLastName(user.getLastName());
        UserFromDatabase.setCitizenship(user.getCitizenship());

        userService.addOrEditUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }
}
