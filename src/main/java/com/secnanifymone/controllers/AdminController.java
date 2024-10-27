package com.secnanifymone.controllers;

import com.secnanifymone.models.MyUser;
import com.secnanifymone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {
        // Retrieve all users
        List<MyUser> allUsers = userService.getAllUsers();

        // Pass the list of users to the view
        model.addAttribute("users", allUsers);

        return "admin-dashboard";
    }
}
