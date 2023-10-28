package com.project.LoanApplicationService.service;

import com.project.LoanApplicationService.domain.Image;
import com.project.LoanApplicationService.domain.LoanApplication;
import com.project.LoanApplicationService.exception.LoanAlreadyExistException;
import com.project.LoanApplicationService.exception.LoanNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface LoanService {
    LoanApplication addDetails(LoanApplication loanApplication) throws LoanAlreadyExistException;
    LoanApplication updateApplication(LoanApplication loanApplication, int id) throws LoanNotFoundException;
    LoanApplication viewApplication(int loanApplicationId) throws LoanNotFoundException;
    List<LoanApplication> viewallApplication();
    List<LoanApplication> listApprovedApplications();
    List<LoanApplication> listRejectedApplications();

    List<LoanApplication> getApplicationsList(String city);
    List<LoanApplication> getApplicationsList(Date date);

    List<LoanApplication> getApplicationByEmail(String email);

    String uploadFile(MultipartFile multipartFile) throws IOException;

    LoanApplication approvedApplication(LoanApplication loanStatus, int id) throws LoanNotFoundException;
    LoanApplication rejectReasonLoan(LoanApplication rejectionReason,int id) throws LoanNotFoundException;
}
