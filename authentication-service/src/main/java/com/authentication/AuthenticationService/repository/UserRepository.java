package com.authentication.AuthenticationService.repository;

import com.authentication.AuthenticationService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {
    User findByUserEmail(String userEmail);
    public User findByUserEmailAndPassword(String userEmail1,String password1);

}
