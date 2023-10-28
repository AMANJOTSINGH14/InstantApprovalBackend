package com.project.LoanApplicationService.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document(collection = "transaction_details")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int transactionId;
    int transactionNo;
    double transactionAmount;
    Date transactionDate;
public Transaction(){

}
    public Transaction(int transactionId, int transactionNo, double transactionAmount, Date transactionDate) {
        this.transactionId = transactionId;
        this.transactionNo = transactionNo;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(int transactionNo) {
        this.transactionNo = transactionNo;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", transactionNo=" + transactionNo +
                ", transactionAmount=" + transactionAmount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
