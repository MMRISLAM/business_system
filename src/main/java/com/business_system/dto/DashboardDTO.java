package com.business_system.dto;

public class DashboardDTO {

    // ===== USER INFO =====
    private String username;
    private String email;
    private String country;
    private String profilePic;
    private String rank;

    // ===== WALLET =====
    private double walletBalance;
    private double creditBalance;

    // ===== INCOME =====
    private double referIncome;
    private double affiliateIncome;
    private double dailyPoolIncome;

    private double roiIncome;
    private double rankIncome;

    private double binaryIncome;
    private double royaltyIncome;

    private double totalIncome;
    private double totalWithdraw;

    // ===== GETTERS & SETTERS =====

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getProfilePic() { return profilePic; }
    public void setProfilePic(String profilePic) { this.profilePic = profilePic; }

    public String getRank() { return rank; }
    public void setRank(String rank) { this.rank = rank; }

    public double getWalletBalance() { return walletBalance; }
    public void setWalletBalance(double walletBalance) { this.walletBalance = walletBalance; }

    public double getCreditBalance() { return creditBalance; }
    public void setCreditBalance(double creditBalance) { this.creditBalance = creditBalance; }

    public double getReferIncome() { return referIncome; }
    public void setReferIncome(double referIncome) { this.referIncome = referIncome; }

    public double getAffiliateIncome() { return affiliateIncome; }
    public void setAffiliateIncome(double affiliateIncome) { this.affiliateIncome = affiliateIncome; }

    public double getDailyPoolIncome() { return dailyPoolIncome; }
    public void setDailyPoolIncome(double dailyPoolIncome) { this.dailyPoolIncome = dailyPoolIncome; }

    public double getRoiIncome() { return roiIncome; }
    public void setRoiIncome(double roiIncome) { this.roiIncome = roiIncome; }

    public double getRankIncome() { return rankIncome; }
    public void setRankIncome(double rankIncome) { this.rankIncome = rankIncome; }

    public double getBinaryIncome() { return binaryIncome; }
    public void setBinaryIncome(double binaryIncome) { this.binaryIncome = binaryIncome; }

    public double getRoyaltyIncome() { return royaltyIncome; }
    public void setRoyaltyIncome(double royaltyIncome) { this.royaltyIncome = royaltyIncome; }

    public double getTotalIncome() { return totalIncome; }
    public void setTotalIncome(double totalIncome) { this.totalIncome = totalIncome; }

    public double getTotalWithdraw() { return totalWithdraw; }
    public void setTotalWithdraw(double totalWithdraw) { this.totalWithdraw = totalWithdraw; }
}
