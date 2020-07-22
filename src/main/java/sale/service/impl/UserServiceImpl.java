package sale.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sale.dao.UserDao;
import sale.entity.User;
import sale.model.UserDTO;
import sale.service.UserService;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public void addUser(UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		user.setPhone(userDTO.getPhone());

		userDao.addUser(user);
	}

	public void updateUser(UserDTO userDTO) {
		User user = userDao.getUserById(userDTO.getId());
		if (user != null) {
			user.setName(userDTO.getName());
			user.setPassword(userDTO.getPassword());
			user.setPhone(userDTO.getPhone());

			userDao.updateUser(user);
		}

	}

	public void delete(int id) {
		User user = userDao.getUserById(id);
		if (user != null) {
			userDao.delete(id);
		}
	}

	public UserDTO getUserById(int id) {
		User user = userDao.getUserById(id);
		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setPassword(user.getPassword());
		userDTO.setPhone(user.getPhone());
		
		return userDTO;
	}

	public List<UserDTO> getAllUser() {
		List<User> users =userDao.getAllUser();
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		
		for(User user:users) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setPassword(user.getPassword());
			userDTO.setPhone(user.getPhone());
			
			userDTOs.add(userDTO);
		}
		
		return userDTOs;
	}

}
