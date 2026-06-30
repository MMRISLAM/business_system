package com.business_system.controller;

import com.business_system.model.User;
import com.business_system.repository.UserRepository;
import com.business_system.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WalletService walletService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {

        User saved = userRepository.save(user);

        walletService.getOrCreateWallet(saved.getId());

        return saved;
    }
}
