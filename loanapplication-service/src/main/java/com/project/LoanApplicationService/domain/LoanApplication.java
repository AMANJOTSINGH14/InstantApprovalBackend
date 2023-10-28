package com.project.LoanApplicationService.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Document(collection = "loan_details")
public class LoanApplication {
    @Id
    int loanApplicationId;

    private String email;

    private  String name;
    private long accountNumber;
    private String applicationDate;



    private String responseDate;
    private int cibilScore;

    private int monthlyIncome;
    private String occupation;
    private double loanAmount;
    private String loanStatus;

    private String document_url;

    private String city;
    private String rejectionReason;

    public LoanApplication(){

    }

    public LoanApplication(int loanApplicationId, String email, String name, long accountNumber, String applicationDate, String responseDate, int cibilScore, int monthlyIncome, String occupation, double loanAmount, String loanStatus, String document_url, String city, String rejectionReason) {
        this.loanApplicationId = loanApplicationId;
        this.email = email;
        this.name = name;
        this.accountNumber = accountNumber;
        this.applicationDate = applicationDate;
        this.responseDate = responseDate;
        this.cibilScore = cibilScore;
        this.monthlyIncome = monthlyIncome;
        this.occupation = occupation;
        this.loanAmount = loanAmount;
        this.loanStatus = loanStatus;
        this.document_url = document_url;
        this.city = city;
        this.rejectionReason = rejectionReason;
    }

    public int getLoanApplicationId() {
        return loanApplicationId;
    }

    public void setLoanApplicationId(int loanApplicationId) {
        this.loanApplicationId = loanApplicationId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(String responseDate) {
        this.responseDate = responseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public int getCibilScore() {
        return cibilScore;
    }

    public void setCibilScore(int cibilScore) {
        this.cibilScore = cibilScore;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getDocument_url() {
        return document_url;
    }

    public void setDocument_url(String document_url) {
        this.document_url = document_url;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    @Override
    public String toString() {
        return "LoanApplication{" +
                "loanApplicationId=" + loanApplicationId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", accountNumber=" + accountNumber +
                ", applicationDate='" + applicationDate + '\'' +
                ", responseDate='" + responseDate + '\'' +
                ", cibilScore=" + cibilScore +
                ", monthlyIncome=" + monthlyIncome +
                ", occupation='" + occupation + '\'' +
                ", loanAmount=" + loanAmount +
                ", loanStatus='" + loanStatus + '\'' +
                ", document_url='" + document_url + '\'' +
                ", city='" + city + '\'' +
                ", rejectionReason='" + rejectionReason + '\'' +
                '}';
    }
}
