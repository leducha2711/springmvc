package sale.service;

import java.util.List;

import sale.model.UserDTO;

public interface UserService {
	public void addUser(UserDTO userDTO);
	public void updateUser(UserDTO userDTO);
	public void delete(int id);
	public UserDTO getUserById(int id);
	public List<UserDTO> getAllUser();
}
