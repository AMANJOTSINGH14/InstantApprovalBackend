package com.example.UserService.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author shubhampatil
 */
@Document(collection = "user_data")
public class User {
    @Id
    private long aadharNo;

    private String email;
    private  String firstName;
    private String lastName;
    private String mobile_No;
    private String password;
    private  String address;

    private BankDetails bankDetails;
    // private String Token;

    public User() {
    }

    public User(long aadharNo, String email, String firstName, String lastName, String mobile_No, String password, String address, BankDetails bankDetails) {
        this.aadharNo = aadharNo;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile_No = mobile_No;
        this.password = password;
        this.address = address;
        this.bankDetails = bankDetails;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile_No() {
        return mobile_No;
    }

    public void setMobile_No(String mobile_No) {
        this.mobile_No = mobile_No;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(long aadharNo) {
        this.aadharNo = aadharNo;
    }

    public BankDetails getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankDetails bankDetails) {
        this.bankDetails = bankDetails;
    }

    @Override
    public String toString() {
        return "User{" +
                "aadharNo=" + aadharNo +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile_No='" + mobile_No + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", bankDetails=" + bankDetails +
                '}';
    }
}
