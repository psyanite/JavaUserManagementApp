package com.umapp.dao;

import java.util.List;

import com.umapp.model.User;
 
public interface UserDao {
 
    User getUserById(int id);
 
    User getUserByUsername(String username);
    
    List<User> getAllUsers();
    
    void createUser(User user);
 
    void deleteUserById(int id);
 
}
