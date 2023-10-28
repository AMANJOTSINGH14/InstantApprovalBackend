package com.example.UserService.Domain;

/**
 * @author shubhampatil
 */
public class BankDetails {
    private long accountNumber;
    private String bankName;
    private String accountHolder;
    private String ifscCode;
    private String branchName;



    public BankDetails() {
    }

    public BankDetails(long accountNumber, String bankName, String accountHolder, String ifscCode, String branchName) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.accountHolder = accountHolder;
        this.ifscCode = ifscCode;
        this.branchName = branchName;

    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }


    @Override
    public String toString() {
        return "BankDetails{" +
                "accountNumber=" + accountNumber +
                ", bankName='" + bankName + '\'' +
                ", accountHolder='" + accountHolder + '\'' +
                ", ifscCode='" + ifscCode + '\'' +
                ", branchName='" + branchName + '\'' +
                '}';
    }
}
