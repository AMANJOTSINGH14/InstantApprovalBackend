package com.project.LoanApplicationService.repository;

import com.project.LoanApplicationService.domain.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction,Integer> {
}
