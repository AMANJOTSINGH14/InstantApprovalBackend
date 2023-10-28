package com.authentication.AuthenticationService.service;

import com.authentication.AuthenticationService.domain.User;
import com.authentication.AuthenticationService.exception.UserAlreadyExistsException;
import com.authentication.AuthenticationService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;



    @Override
    public User addUser(User user) throws UserAlreadyExistsException {
        if(userRepository.findByUserEmail(user.getUserEmail())==null)
        {
            userRepository.save(user);
        }else{
            throw new UserAlreadyExistsException();
        }

        return user;
    }


    @Override
    public User checkUserEmailAndPassword(User user) {
//        String hashedPassword1 = passwordEncoder.encode(user.getPassword());
        User checkUser=userRepository.findByUserEmailAndPassword(user.getUserEmail(), user.getPassword());
        if(checkUser!=null)
        {
            User newUser = userRepository.findByUserEmail(user.getUserEmail());
            return newUser;
        }else
        {
            return null;
        }

    }

    @Override
    public User UpdateAdminStatus(String emailId) {
        User existingUser = userRepository.findByUserEmail(emailId);
        existingUser.setAdmin(true);
        return userRepository.save((existingUser));
    }

    @Override
    public User changePasswordForUSer(String emailId, User password) {
        User user = userRepository.findByUserEmail(emailId);
        System.out.println(user);
            System.out.println(password);
            user.setPassword(password.getPassword());
        System.out.println(password.getPassword());
        System.out.println("Final User" + user);
            return userRepository.save(user);

    }
}
