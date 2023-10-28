package com.project.LoanApplicationService.controller;

import com.netflix.discovery.converters.Auto;
import com.project.LoanApplicationService.domain.Image;
import com.project.LoanApplicationService.domain.LoanApplication;
import com.project.LoanApplicationService.domain.Transaction;
import com.project.LoanApplicationService.exception.LoanAlreadyExistException;
import com.project.LoanApplicationService.exception.LoanNotFoundException;
import com.project.LoanApplicationService.service.LoanServiceimpl;
import com.project.LoanApplicationService.service.TransactionServiceimpl;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/loan")
public class LoanController {
   @Autowired
    TransactionServiceimpl transactionServiceimpl;
    @Autowired
    LoanServiceimpl loanServiceimpl;

    @PostMapping("/addDetail")
    public ResponseEntity<LoanApplication> postDetail( @RequestBody LoanApplication loanApplication) throws LoanAlreadyExistException {

        LoanApplication savedLoanApplication = loanServiceimpl.addDetails(loanApplication);
        return new ResponseEntity<LoanApplication>(savedLoanApplication, HttpStatus.CREATED);
    }

//    @PostMapping("/upload")
//    public String uploadFile(@RequestParam("image")MultipartFile multipartFile,
//                             Model model) throws IOException {
//        String imageURL = loanServiceimpl.uploadFile(multipartFile);
//        model.addAttribute("imageURL",imageURL);
//        return "gallery";
//    }
//
//    @PostMapping("/addImage")
//    public ResponseEntity<Image> addImagetoDB(@RequestBody  String loanApplicationId, @RequestBody MultipartFile file) throws IOException {
//        System.out.println("Excute in controller");
//        Image addImage  = loanServiceimpl.saveImage(loanApplicationId,file);
//        return new ResponseEntity<Image>(addImage, HttpStatus.CREATED);
//    }

    @PostMapping("/up")
    public ResponseEntity<Map> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
       Map data =  loanServiceimpl.upload(file);
      return new ResponseEntity<>(data, HttpStatus.OK);
    }




    @GetMapping("/viewallApplication/{loanApplicationId}")
    public ResponseEntity<?> viewApplication(@PathVariable int loanApplicationId) throws LoanNotFoundException {
      LoanApplication list=loanServiceimpl.viewApplication(loanApplicationId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> viewAllByEmail(@PathVariable String email){
        List<LoanApplication> list = loanServiceimpl.getApplicationByEmail(email);
        System.out.println(list);
        if(list==null){
            return null;
        }
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("/viewallApplication")
    public ResponseEntity<?> viewallApplication() {
        List<LoanApplication> list=loanServiceimpl.viewallApplication();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PutMapping("/updateDetail/{id}")
    public ResponseEntity<LoanApplication> updateDetail(@RequestBody LoanApplication loanApplication,@PathVariable("id") int id) throws LoanNotFoundException {
        LoanApplication savedLoanApplication = loanServiceimpl.updateApplication(loanApplication,id);
        return new ResponseEntity<LoanApplication>(savedLoanApplication, HttpStatus.OK);
    }

    @GetMapping("/getallApplication/{city}")
    public ResponseEntity<?> getallApplicationBycity(@PathVariable("city")String city) {
        List<LoanApplication> list=loanServiceimpl.getApplicationsList(city);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/getallApplication/{date}")
    public ResponseEntity<?> getallApplicationBydate(@PathVariable("date")Date date) {
        List<LoanApplication> list=loanServiceimpl.getApplicationsList(date);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/getApprovedApplication")
    public ResponseEntity<?> getApprovedApplication() {
        List<LoanApplication> list=loanServiceimpl.listApprovedApplications();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/getRejectedApplication")
    public ResponseEntity<?> getRejectedApplication() {
        List<LoanApplication> list=loanServiceimpl.listRejectedApplications();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/getPendingApplication")
    public ResponseEntity<?> getPendingApplication() {
        List<LoanApplication> list=loanServiceimpl.listPendingApplications();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/getAllTransactions")
    public ResponseEntity<?> getAllTransactions() {
        List<Transaction> list=transactionServiceimpl.viewallTransactions();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/approvedLoan/{id}")
    public ResponseEntity<?> updateLoanStatus(@RequestBody LoanApplication loanStatus,@PathVariable int id) throws LoanNotFoundException {
        LoanApplication approvedLoan = loanServiceimpl.approvedApplication(loanStatus,id);
        return new ResponseEntity<LoanApplication>(approvedLoan, HttpStatus.OK);
    }
    @PutMapping("/rejectedLoan/{id}")
    public ResponseEntity<?> updateRejectReason(@RequestBody LoanApplication rejectionReason,@PathVariable int id) throws LoanNotFoundException {

        LoanApplication reasonForReject = loanServiceimpl.rejectReasonLoan(rejectionReason,id);
        return new ResponseEntity<LoanApplication>(reasonForReject, HttpStatus.OK);
    }

}
