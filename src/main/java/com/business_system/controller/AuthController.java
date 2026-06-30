package com.business_system.controller;

import com.business_system.model.User;
import com.business_system.repository.UserRepository;
import com.business_system.service.WalletService;
import org.springframework.stereotype.Controller;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserRepository userRepository;
    private final WalletService walletService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository,
                          WalletService walletService,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.walletService = walletService;
        this.passwordEncoder = passwordEncoder;
    }

    // ================= LOGIN PAGE =================
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // ================= SIGNUP PAGE =================
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    // ================= SIGNUP PROCESS =================
    @PostMapping("/signup")
    public String signup(@RequestParam String username,
                         @RequestParam String password) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        user = userRepository.save(user);

        walletService.getOrCreateWallet(user.getId());

        return "redirect:/login";
    }
}
