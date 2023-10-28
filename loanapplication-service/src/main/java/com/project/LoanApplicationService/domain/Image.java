package com.project.LoanApplicationService.domain;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "document_details")
public class Image {
    @Id
     String loanApplicationId;
    @Lob
    private byte[] image;
   public Image(){

   }
    public Image(String loanApplicationId, byte[] image) {
        this.loanApplicationId = loanApplicationId;
        this.image = image;
    }

    public String getLoanApplicationId() {
        return loanApplicationId;
    }

    public void setLoanApplicationId(String loanApplicationId) {
        this.loanApplicationId = loanApplicationId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Image{" +
                "loanApplicationId=" + loanApplicationId +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
