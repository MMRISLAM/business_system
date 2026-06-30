package com.business_system.model;


import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "wallets")
public class Wallet {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private Long userId;



    // MAIN WALLET

    private Double balance = 0.0;

    private Double deposit = 0.0;

    private Double withdraw = 0.0;



    // SUBSCRIPTION AFFILIATE

    private Double affiliateIncome = 0.0;


    private Double level1Income = 0.0;

    private Double level2Income = 0.0;

    private Double level3Income = 0.0;

    private Double level4Income = 0.0;

    private Double level5Income = 0.0;



    private Double subscriptionIncome = 0.0;



    // POOL

    private Double poolIncome = 0.0;



    // MATRIX

    private Double matrixIncome = 0.0;

    private Double matrixBinaryIncome = 0.0;

    private Double matchingIncome = 0.0;



    // ROI

    private Double roiIncome = 0.0;



    // ROYALTY

    private Double royaltyIncome = 0.0;



    // RANK

    private Double rankReward = 0.0;



    // BONUS

    private Double sponsorBonus = 0.0;


    private Double globalShare = 0.0;



    // SYSTEM

    private Double creditBalance = 0.0;


    private Double totalIncome = 0.0;


    private Double totalWithdraw = 0.0;



}
