package com.authentication.AuthenticationService.service;

import com.authentication.AuthenticationService.domain.User;
import com.authentication.AuthenticationService.exception.UserAlreadyExistsException;

public interface UserService {
    public User addUser(User user) throws UserAlreadyExistsException;
    public User checkUserEmailAndPassword(User user);

    public User UpdateAdminStatus(String emailId);

    public User changePasswordForUSer(String id, User password);
}
