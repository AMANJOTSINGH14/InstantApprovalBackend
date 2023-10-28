package com.project.LoanApplicationService.service;

import com.cloudinary.Cloudinary;
import com.project.LoanApplicationService.domain.Image;
import com.project.LoanApplicationService.domain.LoanApplication;
import com.project.LoanApplicationService.exception.LoanAlreadyExistException;
import com.project.LoanApplicationService.exception.LoanNotFoundException;
import com.project.LoanApplicationService.repository.ImageRepository;
import com.project.LoanApplicationService.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class LoanServiceimpl implements LoanService{
   @Autowired
    LoanRepository loanRepository;

   @Autowired
    ImageRepository imageRepository;

   @Autowired
   Cloudinary cloudinary;



    @Override
    public String uploadFile(MultipartFile multipartFile) throws IOException {
        return cloudinary.uploader()
                .upload(multipartFile.getBytes(),
                        Map.of("public_id", UUID.randomUUID().toString()))
                .get("url")
                .toString();
    }
    public Map upload(MultipartFile file) throws IOException {
        try {
            Map data = this.cloudinary.uploader().upload(file.getBytes(), Map.of());
            return data;

        }catch (IOException e){
            throw new IOException("image uploading fail");
        }
    }
    @Override
    public LoanApplication addDetails(LoanApplication loanApplication) throws LoanAlreadyExistException {
        boolean loanAppPresent= loanRepository.findById(loanApplication.getLoanApplicationId()).isPresent();
        if(loanAppPresent){
            throw new LoanAlreadyExistException();
        }
        else{
            loanRepository.save(loanApplication);
            return loanApplication;
        }
    }

    public Image saveImage(String loanApplicationId, MultipartFile file) throws IOException{
        System.out.println("executed");
        Image image = new Image();
        image.setLoanApplicationId(loanApplicationId);
        image.setImage(file.getBytes());
        return imageRepository.save(image);

    }


    @Override
    public LoanApplication updateApplication(LoanApplication loanApplication,int id)throws LoanNotFoundException {
        boolean foundloan=loanRepository.findById(id).isPresent();
        if(foundloan){
            LoanApplication loanApplication1=loanRepository.findById(id).get();
            loanApplication1.setApplicationDate(loanApplication.getApplicationDate());
            loanApplication1.setLoanAmount(loanApplication.getLoanAmount());
            loanApplication1.setLoanStatus(loanApplication.getLoanStatus());
            loanApplication1.setCibilScore(loanApplication.getCibilScore());
//            loanApplication1.setDocumentUploaded(loanApplication.getDocumentUploaded());
            loanApplication1.setRejectionReason(loanApplication.getRejectionReason());
            loanRepository.save(loanApplication1);
            return loanApplication1;
        }
        else{
            throw new LoanNotFoundException();
        }

    }

    @Override
    public LoanApplication viewApplication(int loanApplicationId) throws LoanNotFoundException {
        boolean isLoanPresent = loanRepository.findById(loanApplicationId).isPresent();
        if(!isLoanPresent){
            throw new LoanNotFoundException();
        }
        return loanRepository.findById(loanApplicationId).get();
    }

    @Override
    public List<LoanApplication> viewallApplication() {
//        return null;
       List<LoanApplication> listAll= loanRepository.findAll();
        return listAll;
    }

    @Override
    public List<LoanApplication> listApprovedApplications() {
        return loanRepository.findByLoanStatus("Approved");
    }

    @Override
    public List<LoanApplication> listRejectedApplications() {
        return loanRepository.findByLoanStatus("Rejected");
    }
    public List<LoanApplication> listPendingApplications() {
        return loanRepository.findByLoanStatus("Pending");
    }



    @Override
    public List<LoanApplication> getApplicationsList(String city) {
        return loanRepository.findByCity(city);
    }



    @Override
    public List<LoanApplication> getApplicationsList(Date date) {

        return loanRepository.findByApplicationDate(date);
    }

    @Override
    public List<LoanApplication> getApplicationByEmail(String email) {
        return loanRepository.findByEmail(email);
    }

    @Override
    public LoanApplication approvedApplication(LoanApplication loanStatus, int id) throws LoanNotFoundException {
        boolean foundloan=loanRepository.findById(id).isPresent();
        if(foundloan){
            LoanApplication loanApplication1=loanRepository.findById(id).get();
            loanApplication1.setLoanStatus(loanStatus.getLoanStatus());
            loanApplication1.setResponseDate(new Date().toString());
            loanRepository.save(loanApplication1);
            return loanApplication1;
        }
        else{
            throw new LoanNotFoundException();
        }

    }

    @Override
    public LoanApplication rejectReasonLoan(LoanApplication rejectionReason, int id) throws LoanNotFoundException {
        boolean foundloan=loanRepository.findById(id).isPresent();
        System.out.println(id);
        if(foundloan){
            LoanApplication loanApplication1=loanRepository.findById(id).get();
            System.out.println(rejectionReason);
            loanApplication1.setRejectionReason(rejectionReason.getRejectionReason());

            loanRepository.save(loanApplication1);
            return loanApplication1;
        }
        else{
            throw new LoanNotFoundException();
        }
    }
}
