package com.business_system.controller;

import com.business_system.model.User;
import com.business_system.repository.UserRepository;
import com.business_system.service.WalletService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BusinessDashboardController {

    private final WalletService walletService;
    private final UserRepository userRepository;

    public BusinessDashboardController(WalletService walletService,
                                       UserRepository userRepository) {
        this.walletService = walletService;
        this.userRepository = userRepository;
    }

    @GetMapping("/businessdashboard")
    public String dashboard(Model model, Authentication auth) {

        // 🔥 SECURITY CHECK
        if (auth == null) {
            return "redirect:/login";
        }

        String username = auth.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        model.addAttribute("wallet",
                walletService.getOrCreateWallet(user.getId()));

        model.addAttribute("userName", user.getUsername());

        model.addAttribute("activeUsers", 12450);
        model.addAttribute("totalNodes", 89320);
        model.addAttribute("dailyRoi", 8920);
        model.addAttribute("todayEarn", 2340);

        return "businessdashboard";
    }
}
