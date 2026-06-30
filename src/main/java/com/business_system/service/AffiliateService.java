package com.business_system.service;


import com.business_system.model.User;
import com.business_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AffiliateService {



    @Autowired
    private WalletService walletService;


    @Autowired
    private UserRepository userRepo;




    // =========================================
    // SUBSCRIPTION AFFILIATE INCOME
    //
    // L1 = 30%
    // L2 = 10%
    // L3 = 5%
    // L4 = 3%
    // L5 = 2%
    //
    // Source: Subscription Payment
    // =========================================


    public void paySubscriptionAffiliateIncome(
            Long userId,
            double subscriptionAmount
    ){


        Long currentUser = userId;



        double[] affiliateRate = {

                0.30,
                0.10,
                0.05,
                0.03,
                0.02

        };



        for(int level=0; level<5; level++){


            User user =
                    userRepo.findById(currentUser)
                    .orElse(null);



            if(user == null)
                break;



            Long sponsorId =
                    user.getSponsorId();



            if(sponsorId == null)
                break;




            double income =
                    subscriptionAmount * affiliateRate[level];



            walletService.addAffiliateIncome(
                    sponsorId,
                    income
            );



            currentUser = sponsorId;

        }


    }





    // =========================================
    // SUBSCRIPTION RANK MONTHLY SHARE
    //
    // L1 = $2/member
    // L2 = $1.5/member
    // L3 = $1.5/member
    // L4 = $1/member
    // L5 = $1/member
    //
    // =========================================


    public void paySubscriptionRankIncome(
            Long userId,
            int level,
            int activeMembers
    ){


        double[] rankShare = {

                2.0,
                1.5,
                1.5,
                1.0,
                1.0

        };



        if(level < 1 || level > 5)
            return;



        double income =
                rankShare[level-1]
                *
                activeMembers;



        walletService.addRankIncome(
                userId,
                income
        );


    }




    // =========================================
    // SUBSCRIPTION STAR RANK REWARD
    // =========================================


    public void checkSubscriberRank(
            Long userId,
            int members
    ){



        double reward = 0;


        if(members >= 100000)
            reward = 100000;


        else if(members >= 10000)
            reward = 10000;


        else if(members >= 1000)
            reward = 1500;


        else if(members >= 100)
            reward = 150;


        else if(members >= 10)
            reward = 20;




        if(reward > 0){

            walletService.addRankIncome(
                    userId,
                    reward
            );

        }


    }




}
