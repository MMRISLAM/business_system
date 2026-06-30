package com.business_system.service;

import com.business_system.model.User;
import com.business_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    // =========================
    // GET USER
    // =========================
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // =========================
    // GET ALL USERS
    // =========================
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // =========================
    // BLOCK USER (SIMULATION)
    // =========================
    public String blockUser(Long userId) {

        User user = getUserById(userId);

        user.setUserRank("BLOCKED"); // simple status system
        userRepository.save(user);

        return "User Blocked Successfully";
    }

    // =========================
    // MAKE ADMIN
    // =========================
    public String makeAdmin(Long userId) {

        User user = getUserById(userId);

        user.setUserRank("ADMIN");
        userRepository.save(user);

        return "User promoted to ADMIN";
    }

    // =========================
    // DELETE USER
    // =========================
    public String deleteUser(Long userId) {

        User user = getUserById(userId);

        userRepository.delete(user);

        return "User deleted successfully";
    }
}
