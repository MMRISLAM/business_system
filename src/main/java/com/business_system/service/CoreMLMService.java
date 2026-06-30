package com.business_system.service;

import com.business_system.model.Wallet;
import com.business_system.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreMLMService {


    @Autowired
    private WalletRepository walletRepo;



    // =========================
    // WALLET GET / CREATE
    // =========================

    private Wallet getWallet(Long userId){

        return walletRepo.findByUserId(userId)
                .orElseGet(() -> createWallet(userId));
    }



    // =========================
    // DEPOSIT
    // =========================

    public Wallet deposit(Long userId, Double amount){

        Wallet w = getWallet(userId);

        w.setBalance(w.getBalance()+amount);

        w.setDeposit(w.getDeposit()+amount);

        return walletRepo.save(w);
    }



    // =========================
    // WITHDRAW
    // =========================

    public Wallet withdraw(Long userId, Double amount){

        Wallet w = getWallet(userId);


        if(w.getBalance() < amount)
            throw new RuntimeException("Insufficient Balance");


        w.setBalance(
                w.getBalance()-amount
        );


        w.setWithdraw(
                w.getWithdraw()+amount
        );


        w.setTotalWithdraw(
                w.getTotalWithdraw()+amount
        );


        return walletRepo.save(w);
    }



    // =========================
    // AFFILIATE LEVEL INCOME
    // =========================

    public void affiliateIncome(
            Long userId,
            int level,
            Double amount
    ){

        Wallet w=getWallet(userId);


        w.setBalance(
                w.getBalance()+amount
        );


        if(level==1)
            w.setLevel1Income(
                    w.getLevel1Income()+amount
            );

        if(level==2)
            w.setLevel2Income(
                    w.getLevel2Income()+amount
            );

        if(level==3)
            w.setLevel3Income(
                    w.getLevel3Income()+amount
            );

        if(level==4)
            w.setLevel4Income(
                    w.getLevel4Income()+amount
            );

        if(level==5)
            w.setLevel5Income(
                    w.getLevel5Income()+amount
            );


        w.setAffiliateIncome(
                w.getAffiliateIncome()+amount
        );


        w.setTotalIncome(
                w.getTotalIncome()+amount
        );


        walletRepo.save(w);
    }




    // =========================
    // ROI INCOME
    // =========================

    public void roiIncome(
            Long userId,
            Double amount
    ){

        Wallet w=getWallet(userId);


        w.setBalance(
                w.getBalance()+amount
        );


        w.setRoiIncome(
                w.getRoiIncome()+amount
        );


        w.setTotalIncome(
                w.getTotalIncome()+amount
        );


        walletRepo.save(w);

    }




    // =========================
    // MATRIX MATCHING
    // =========================

    public void matrixIncome(
            Long userId,
            Double amount
    ){

        Wallet w=getWallet(userId);


        w.setBalance(
                w.getBalance()+amount
        );


        w.setMatrixIncome(
                w.getMatrixIncome()+amount
        );


        w.setMatchingIncome(
                w.getMatchingIncome()+amount
        );


        w.setTotalIncome(
                w.getTotalIncome()+amount
        );


        walletRepo.save(w);

    }




    // =========================
    // ROYALTY
    // =========================

    public void royaltyIncome(
            Long userId,
            Double amount
    ){

        Wallet w=getWallet(userId);


        w.setBalance(
                w.getBalance()+amount
        );


        w.setRoyaltyIncome(
                w.getRoyaltyIncome()+amount
        );


        w.setTotalIncome(
                w.getTotalIncome()+amount
        );


        walletRepo.save(w);

    }




    // =========================
    // RANK REWARD
    // =========================

    public void rankReward(
            Long userId,
            Double amount
    ){

        Wallet w=getWallet(userId);


        w.setBalance(
                w.getBalance()+amount
        );


        w.setRankReward(
                w.getRankReward()+amount
        );


        w.setTotalIncome(
                w.getTotalIncome()+amount
        );


        walletRepo.save(w);

    }




    // =========================
    // CREATE WALLET
    // =========================

    private Wallet createWallet(Long userId){

        Wallet w=new Wallet();

        w.setUserId(userId);

        return walletRepo.save(w);
    }

}
