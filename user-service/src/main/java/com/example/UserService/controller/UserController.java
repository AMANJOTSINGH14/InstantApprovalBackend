package com.example.UserService.controller;

import com.example.UserService.Domain.BankDetails;
import com.example.UserService.Domain.PasswordChangeRequest;
import com.example.UserService.Domain.User;
import com.example.UserService.Exceptions.PasswordNotMatch;
import com.example.UserService.Exceptions.UserAlreadyExistsException;
import com.example.UserService.Exceptions.UserNotFoundException;
import com.example.UserService.Repository.UserRepository;
import com.example.UserService.Services.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shubhampatil
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServicesImpl userServiceImpl;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/AddUser")
    public ResponseEntity<?> adduser(@RequestBody User user) throws UserAlreadyExistsException {
        userServiceImpl.AddUser(user);
        return new ResponseEntity<>("User Added", HttpStatus.OK);
    }
//    @PutMapping("/changePassword/{id}")
//    public ResponseEntity<?>getA(@PathVariable String id, @RequestBody PasswordChangeRequest data) throws PasswordNotMatch {
//        User user = userServiceImpl.changePasswordForUSer(id, data);
//        return new ResponseEntity<>("updated", HttpStatus.OK);
//    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers() {
        List<User> userList = userServiceImpl.getAllUser();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable long id) throws UserNotFoundException {
        User user = userServiceImpl.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @PutMapping("/updatePassword/{id}")
//    public ResponseEntity<?> changePassword(@PathVariable int id, String current_password, String new_password) {
//        boolean user = userServiceImpl.changePassword(id, current_password, new_password);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//
//    }
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable long id) throws UserNotFoundException {
        try {
            User user1 = userServiceImpl.updateUser(user, id);
            return new ResponseEntity<>("User Updated", HttpStatus.OK);
        }catch(UserNotFoundException e){
            return new ResponseEntity<>("user doesnt exist",HttpStatus.OK);
        }
    }

    @PutMapping("/updateUserAndBankDetails/{aadharNo}")
    public ResponseEntity<?>  updateUserAndBankDetails(@PathVariable long aadharNo, @RequestBody User updatedUser) throws UserNotFoundException {
        try {
            User user = userServiceImpl.updateUserAndBankDetails(aadharNo, updatedUser);
            return new ResponseEntity<>("User and Bank details Updated", HttpStatus.OK);
        }catch(UserNotFoundException e){
            return new ResponseEntity<>("user doesnt exist",HttpStatus.OK);
        }
    }

    //    @PostMapping("/initiatePasswordReset")
//    public ResponseEntity<?> initiatePasswordReset(@PathVariable String Email){
//         User user=userServiceImpl.initiatePasswordReset(Email);
//         return new ResponseEntity<>("Email sent to register Email Id", HttpStatus.OK);
//    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) throws UserNotFoundException {
        User user = userServiceImpl.deleteUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping("/geBankDetails/{id}")
    public ResponseEntity<?> geBankDetails(@PathVariable int id) throws UserNotFoundException {
        BankDetails bankDetails = userServiceImpl.getBankDetails(id);
        return new ResponseEntity<>(bankDetails, HttpStatus.OK);
    }
}
