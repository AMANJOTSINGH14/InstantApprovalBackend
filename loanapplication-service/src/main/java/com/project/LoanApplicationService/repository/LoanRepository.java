package com.project.LoanApplicationService.repository;

import com.project.LoanApplicationService.domain.LoanApplication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@EnableMongoRepositories
public interface LoanRepository extends MongoRepository<LoanApplication,Integer> {

List<LoanApplication> findByLoanStatus(String loanStatus);



    List<LoanApplication> findByCity(String city);

    List<LoanApplication> findByEmail(String email);

    List<LoanApplication> findByApplicationDate(Date date);

}
