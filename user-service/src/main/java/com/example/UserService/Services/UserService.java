package com.example.UserService.Services;

import com.example.UserService.Domain.BankDetails;
import com.example.UserService.Domain.PasswordChangeRequest;
import com.example.UserService.Domain.User;
import com.example.UserService.Exceptions.PasswordNotMatch;
import com.example.UserService.Exceptions.UserAlreadyExistsException;
import com.example.UserService.Exceptions.UserNotFoundException;

import java.util.List;

/**
 * @author shubhampatil
 */
public interface UserService {
    public List<User> getAllUser();
    public User AddUser(User user) throws UserAlreadyExistsException;
    public User getUserById(long id) throws UserNotFoundException;
    public User deleteUser(long id) throws UserNotFoundException;
    public BankDetails getBankDetails(long id) throws UserNotFoundException;
    public User updateUser(User user, long userId) throws UserNotFoundException;
    public User updateUserAndBankDetails(long aadharNo, User updatedUser) throws UserNotFoundException;
//    public User changePasswordForUser(long userId, PasswordChangeRequest data) throws UserNotFoundException, PasswordNotMatch;
}
