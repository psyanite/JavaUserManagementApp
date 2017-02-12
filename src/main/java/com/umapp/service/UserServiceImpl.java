package com.umapp.service;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.umapp.dao.UserDao;
import com.umapp.model.User;
 
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
 
    @Autowired
    private UserDao dao;
 
    /*
     * Since we are using Spring Transaction, we don't need to explicitly save.
     * Just update the entity with within the transaction.
     * Changes will be committed once transaction ends. 
     */
    public void updateUser(User user) {
        User entity = dao.getUserById(user.getUserId());
        if (entity!=null){
            entity.setUsername(user.getUsername());
            entity.setFirstname(user.getFirstname());
            entity.setLastname(user.getLastname());
            entity.setDateOfBirth(user.getDateOfBirth());
            entity.setEmail(user.getEmail());
            entity.setPhone(user.getPhone());
            entity.setMobile(user.getMobile());
        }
    }
 
    public void deleteUserBySsn(String ssn) {
    }
     
	@Override
	public User getUserById(int id) {
        return dao.getUserById(id);
	}

	@Override
	public User getUserByUsername(String username) {
        return dao.getUserByUsername(username);
	}

	@Override
	public void createUser(User user) {
        dao.createUser(user);
	}

	@Override
	public void deleteUserById(int id) {
        dao.deleteUserById(id);
	}

	@Override
	public List<User> getAllUsers() {
        return dao.getAllUsers();
	}

	@Override
	public boolean isUsernameUnique(Integer id, String username) {
        User user = getUserByUsername(username);
        return (user == null || ((id != null) && (user.getUserId() == id)));
	}
     
}