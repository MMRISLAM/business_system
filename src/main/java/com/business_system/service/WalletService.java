package com.business_system.service;


import com.business_system.model.Wallet;
import com.business_system.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class WalletService {



    @Autowired
    private WalletRepository walletRepository;




    // =====================================
    // GET OR CREATE WALLET
    // =====================================

    public Wallet getOrCreateWallet(Long userId){


        return walletRepository.findByUserId(userId)

        .orElseGet(() -> {


            Wallet w = new Wallet();


            w.setUserId(userId);


            w.setBalance(0.0);

            w.setDeposit(0.0);

            w.setWithdraw(0.0);


            w.setAffiliateIncome(0.0);


            w.setLevel1Income(0.0);
            w.setLevel2Income(0.0);
            w.setLevel3Income(0.0);
            w.setLevel4Income(0.0);
            w.setLevel5Income(0.0);


            w.setSubscriptionIncome(0.0);

            w.setPoolIncome(0.0);


            w.setMatrixIncome(0.0);

            w.setMatrixBinaryIncome(0.0);

            w.setMatchingIncome(0.0);


            w.setRoiIncome(0.0);


            w.setRoyaltyIncome(0.0);


            w.setRankReward(0.0);


            w.setSponsorBonus(0.0);

            w.setGlobalShare(0.0);


            w.setCreditBalance(0.0);


            w.setTotalIncome(0.0);

            w.setTotalWithdraw(0.0);



            return walletRepository.save(w);

        });

    }






    // =====================================
    // DEPOSIT
    // =====================================

    public Wallet deposit(
            Long userId,
            double amount
    ){

        Wallet w=getOrCreateWallet(userId);


        w.setBalance(
                w.getBalance()+amount
        );


        w.setDeposit(
                w.getDeposit()+amount
        );


        return walletRepository.save(w);

    }







    // =====================================
    // WITHDRAW
    // =====================================

    public Wallet withdraw(
            Long userId,
            double amount
    ){

        Wallet w=getOrCreateWallet(userId);



        if(w.getBalance()<amount)

            throw new RuntimeException(
                    "Insufficient balance"
            );



        w.setBalance(
                w.getBalance()-amount
        );


        w.setWithdraw(
                w.getWithdraw()+amount
        );


        w.setTotalWithdraw(
                w.getTotalWithdraw()+amount
        );



        return walletRepository.save(w);

    }







    // =====================================
    // AFFILIATE INCOME
    // =====================================

    public Wallet addAffiliateIncome(
            Long userId,
            double amount
    ){

        Wallet w=getOrCreateWallet(userId);



        w.setAffiliateIncome(
                w.getAffiliateIncome()+amount
        );


        w.setBalance(
                w.getBalance()+amount
        );


        w.setTotalIncome(
                w.getTotalIncome()+amount
        );



        return walletRepository.save(w);

    }







    // =====================================
    // SUBSCRIPTION RANK INCOME
    // =====================================

    public Wallet addRankIncome(
            Long userId,
            double amount
    ){

        Wallet w=getOrCreateWallet(userId);



        w.setRankReward(
                w.getRankReward()+amount
        );


        w.setBalance(
                w.getBalance()+amount
        );


        w.setTotalIncome(
                w.getTotalIncome()+amount
        );



        return walletRepository.save(w);

    }



}
