package com.umapp.dao;

import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.umapp.model.User;
 
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Override
    public User getUserById(int id) {
        return getByKey(id);
    }
	
	@Override
	public User getUserByUsername(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
	}

    @SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
	}

	@Override
    public void createUser(User user) {
        persist(user);
    }

	@Override
	public void deleteUserById(int id) {
        Query query = getSession().createSQLQuery("DELETE FROM user WHERE user_id = :id");
        query.setString("id", Integer.toString(id));
        query.executeUpdate();
	}
}
