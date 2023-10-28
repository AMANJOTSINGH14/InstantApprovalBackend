package com.project.LoanApplicationService.repository;

import com.project.LoanApplicationService.domain.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface ImageRepository extends MongoRepository<Image, Integer> {
}
