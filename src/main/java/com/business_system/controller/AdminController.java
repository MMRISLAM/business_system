package com.business_system.controller;

import com.business_system.model.User;
import com.business_system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // =========================
    // GET ALL USERS
    // =========================
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    // =========================
    // GET USER BY ID
    // =========================
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return adminService.getUserById(id);
    }

    // =========================
    // BLOCK USER
    // =========================
    @PostMapping("/block/{id}")
    public String blockUser(@PathVariable Long id) {
        return adminService.blockUser(id);
    }

    // =========================
    // MAKE ADMIN
    // =========================
    @PostMapping("/make-admin/{id}")
    public String makeAdmin(@PathVariable Long id) {
        return adminService.makeAdmin(id);
    }

    // =========================
    // DELETE USER
    // =========================
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        return adminService.deleteUser(id);
    }
}
