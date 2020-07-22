package sale.dao;

import java.util.List;

import sale.entity.User;

public interface UserDao {
	public void addUser(User user);
	public void updateUser(User user);
	public void delete(int id);
	public User getUserById(int id);
	public List<User> getAllUser();
	
}
