package com.example.crud_app_spring_boot.controller;

import com.example.crud_app_spring_boot.model.User;
import com.example.crud_app_spring_boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    };

    @GetMapping("/")
    public String emptyPageMethod() {
        return "empty-page";
    }

    @GetMapping("/getAll")
    public String getAllUsers(Model model) {
        model.addAttribute("allUsers",userService.getAll());
        return "all-users";
    }

    @GetMapping("/addUser")
    public String addUser(User user) {
        return "add-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(User user) {
        userService.save(user);
        return "redirect:/getAll";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/getAll";
    }


}
