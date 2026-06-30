package com.business_system.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "users")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // =========================
    // BASIC INFO
    // =========================

    private String username;

    private String email;

    private String password;

    private String country;

    private String profilePic;



    // =========================
    // RANK SYSTEM
    // =========================

    private String userRank = "NONE";



    // =========================
    // REFERRAL SYSTEM
    // =========================

    private Long sponsorId;

    private String referralCode;



    // =========================
    // SUBSCRIPTION
    // =========================

    private Boolean active = false;

    private Double subscriptionAmount = 0.0;



    // =========================
    // MATRIX POSITION
    // =========================

    private Long parentId;

    private String position; 
    // LEFT / RIGHT



    // =========================
    // DATE
    // =========================

    private LocalDateTime joinDate =
            LocalDateTime.now();



    @Enumerated(EnumType.STRING)
    private Role role;



    // =========================
    // GETTERS
    // =========================


    public Long getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }


    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }


    public String getCountry() {
        return country;
    }


    public String getProfilePic() {
        return profilePic;
    }


    public String getUserRank() {
        return userRank;
    }


    public Long getSponsorId() {
        return sponsorId;
    }


    public String getReferralCode() {
        return referralCode;
    }


    public Boolean getActive() {
        return active;
    }


    public Double getSubscriptionAmount() {
        return subscriptionAmount;
    }


    public Long getParentId() {
        return parentId;
    }


    public String getPosition() {
        return position;
    }


    public LocalDateTime getJoinDate() {
        return joinDate;
    }


    public Role getRole() {
        return role;
    }



    // =========================
    // SETTERS
    // =========================


    public void setId(Long id) {
        this.id = id;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public void setCountry(String country) {
        this.country = country;
    }


    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }


    public void setUserRank(String userRank) {
        this.userRank = userRank;
    }


    public void setSponsorId(Long sponsorId) {
        this.sponsorId = sponsorId;
    }


    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }


    public void setActive(Boolean active) {
        this.active = active;
    }


    public void setSubscriptionAmount(Double subscriptionAmount) {
        this.subscriptionAmount = subscriptionAmount;
    }


    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


    public void setPosition(String position) {
        this.position = position;
    }


    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }


    public void setRole(Role role) {
        this.role = role;
    }

}
