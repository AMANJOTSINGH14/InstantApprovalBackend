package com.example.UserService.Services;

import com.example.UserService.Domain.BankDetails;
import com.example.UserService.Domain.PasswordChangeRequest;
import com.example.UserService.Domain.User;
import com.example.UserService.Exceptions.PasswordNotMatch;
import com.example.UserService.Exceptions.UserAlreadyExistsException;
import com.example.UserService.Exceptions.UserNotFoundException;
import com.example.UserService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

/**
 * @author shubhampatil
 */
@Service
public class UserServicesImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        List<User> UserList = (List<User>) userRepository.findAll();
        return UserList;
    }

    @Override
    public User AddUser(User user) throws UserAlreadyExistsException {

        if (userRepository.findById(user.getAadharNo()).isPresent()) {
            throw new UserAlreadyExistsException();
        } else

            userRepository.save(user);
        return user;

    }

    @Override
    public User getUserById(@PathVariable long id) throws UserNotFoundException {
        try {
            User user = userRepository.findById(id).get();
            return user;

        } catch (Exception e) {
            throw new UserNotFoundException();
        }
    }
    @Override
    public BankDetails getBankDetails(long id) throws UserNotFoundException {
        try {
            User user = userRepository.findById(id).get();
            BankDetails bankDetails = user.getBankDetails();
            return bankDetails;
        } catch (Exception e) {
            throw new UserNotFoundException();
        }


    }

    @Override
    public User deleteUser(long id) throws UserNotFoundException {
        try{
            User user = userRepository.findById(id).get();


            userRepository.deleteById(id);
            return user;
        }catch (Exception c){
            throw  new UserNotFoundException();

        }
    }

    @Override
    public User updateUser(User user, long userId) throws UserNotFoundException{

        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setMobile_No(user.getMobile_No());
            userToUpdate.setAadharNo(user.getAadharNo());
            userToUpdate.setAddress(user.getAddress());
            return userRepository.save(userToUpdate);
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public User updateUserAndBankDetails(long aadharNo, User updatedUser) throws UserNotFoundException{
        User existingUser = userRepository.findByAadharNo(aadharNo);
        if (existingUser == null) {
            throw new UserNotFoundException();
        }
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setMobile_No(updatedUser.getMobile_No());
        existingUser.setAddress(updatedUser.getAddress());

        BankDetails updatedBankDetails = updatedUser.getBankDetails();
        BankDetails existingBankDetails = existingUser.getBankDetails();

        existingBankDetails.setAccountNumber(updatedBankDetails.getAccountNumber());
        existingBankDetails.setBankName(updatedBankDetails.getBankName());
        existingBankDetails.setAccountHolder(updatedBankDetails.getAccountHolder());
        existingBankDetails.setIfscCode(updatedBankDetails.getIfscCode());
        existingBankDetails.setBranchName(updatedBankDetails.getBranchName());

        userRepository.save(existingUser);

        return existingUser;
    }


//    @Override
//    public User changePasswordForUser(long userId, PasswordChangeRequest data) throws PasswordNotMatch {
//        User user = userRepository.findById(userId).get();
//        String oldPassword = user.getPassword();
//        String providedOldPassword = data.getCurrent_pass();
//        if(oldPassword.equalsIgnoreCase(providedOldPassword)){
//            user.setPassword(data.getNew_pass());
//            return userRepository.save(user);
//        }else{
//           throw new PasswordNotMatch();
//        }
//
//    }


}
