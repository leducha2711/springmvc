package sale.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sale.dao.UserDao;
import sale.entity.Product;
import sale.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().merge(user);
	}

	public void delete(int id) {
		sessionFactory.getCurrentSession().delete(getUserById(id));
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public List<User> getAllUser() {
		 Session session = this.sessionFactory.getCurrentSession();
		    return session.createQuery("FROM user", User.class).getResultList();
	}

	
	

}
