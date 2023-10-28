package com.example.UserService.Repository;

import com.example.UserService.Domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author shubhampatil
 */
@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    User findByAadharNo(long aadharNo);
}
