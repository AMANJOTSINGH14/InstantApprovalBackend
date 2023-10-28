package com.authentication.AuthenticationService.controller;



import com.authentication.AuthenticationService.domain.User;
import com.authentication.AuthenticationService.exception.UserAlreadyExistsException;
import com.authentication.AuthenticationService.service.SecurityTokenGeneratorImpl;
import com.authentication.AuthenticationService.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    SecurityTokenGeneratorImpl securityTokenGeneratorImpl;


    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody User user) throws UserAlreadyExistsException {
        User user1=userServiceImpl.addUser(user);
        return  new ResponseEntity<>(user1, HttpStatus.OK);

    }

    @PostMapping("/login")
    public ResponseEntity<?> checkUserEmailAndPassword(@RequestBody User user)
    {
        Map<String,String> jwttoken=new HashMap<>();

        User user1=userServiceImpl.checkUserEmailAndPassword(user);
        if(user1!=null)
        {
            jwttoken=securityTokenGeneratorImpl.generateToken(user);
            System.out.println(user1);
            if(user1.getAdmin()==null){
                jwttoken.put("isAdmin","false");
            }else{
                jwttoken.put("isAdmin","true");
            }
            return new ResponseEntity<>(jwttoken, HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>("Check login credentials ",HttpStatus.NOT_FOUND);

        }
    }

    @PutMapping("/updateUser/{emailId}")
    public ResponseEntity<?> updateUser(@PathVariable String emailId) {
        try {

            User updatedUser = userServiceImpl.UpdateAdminStatus(emailId);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/changePassword/{id}")
    public ResponseEntity<?>changePassword(@PathVariable String id, @RequestBody User password)  {
        User user = userServiceImpl.changePasswordForUSer(id, password);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
