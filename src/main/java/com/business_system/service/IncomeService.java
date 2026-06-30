package com.business_system.service;

import com.business_system.model.Wallet;
import com.business_system.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IncomeService {

    @Autowired
    private WalletRepository walletRepo;

    // Level commission (1-5)
    private final double[] LEVEL_PERCENT = {
            0.30, 0.10, 0.05, 0.03, 0.02
    };

    // ✅ MAIN AFFILIATE DISTRIBUTION ENGINE
    public void distributeIncome(Long userId, double amount, Long sponsorId) {

        Long current = sponsorId;

        for (int level = 0; level < 5; level++) {

            if (current == null || current <= 0) break;

            double income = amount * LEVEL_PERCENT[level];

            Optional<Wallet> opt = walletRepo.findByUserId(current);

            if (opt.isPresent()) {
                Wallet w = opt.get();

                w.setAffiliateIncome(w.getAffiliateIncome() + income);
                w.setBalance(w.getBalance() + income);
                w.setTotalIncome(w.getTotalIncome() + income);

                walletRepo.save(w);
            }

            // demo fallback (replace later with real referral chain)
            current = current - 1;
        }
    }
}
