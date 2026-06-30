package com.business_system.service;

import com.business_system.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private WalletService walletService;

    public Wallet getDashboard(Long userId) {
        return walletService.getOrCreateWallet(userId);
    }
}
