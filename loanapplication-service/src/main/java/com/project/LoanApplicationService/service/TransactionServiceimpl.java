package com.project.LoanApplicationService.service;

import com.project.LoanApplicationService.domain.Transaction;
import com.project.LoanApplicationService.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServiceimpl implements TransactionService{
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> viewallTransactions() {
        return transactionRepository.findAll();
    }
}
