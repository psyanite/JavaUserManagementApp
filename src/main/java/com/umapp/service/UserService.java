package com.umapp.service;

import java.util.List;

import com.umapp.model.User;
 
public interface UserService {
 
    User getUserById(int id);
    
    User getUserByUsername(String username);
     
    void createUser(User user);
     
    void updateUser(User user);
     
    void deleteUserById(int id);
 
    List<User> getAllUsers(); 
 
    boolean isUsernameUnique(Integer id, String username);
     
}