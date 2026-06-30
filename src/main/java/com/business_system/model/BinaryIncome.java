package com.business_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "binary_income")
public class BinaryIncome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int userId;
    private double roiIncome;
    private double binaryIncome;
    private double affiliateIncome;
    private double totalIncome;

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getRoiIncome() {
        return roiIncome;
    }

    public void setRoiIncome(double roiIncome) {
        this.roiIncome = roiIncome;
    }

    public double getBinaryIncome() {
        return binaryIncome;
    }

    public void setBinaryIncome(double binaryIncome) {
        this.binaryIncome = binaryIncome;
    }

    public double getAffiliateIncome() {
        return affiliateIncome;
    }

    public void setAffiliateIncome(double affiliateIncome) {
        this.affiliateIncome = affiliateIncome;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }
}
