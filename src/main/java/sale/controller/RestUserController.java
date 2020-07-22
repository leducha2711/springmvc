package sale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sale.model.UserDTO;
import sale.service.UserService;

@RestController
public class RestUserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/list-users", method = RequestMethod.GET)
	public List<UserDTO> listUsers() {

		List<UserDTO> users = userService.getAllUser();

		return users;
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public UserDTO viewUser(
			@PathVariable(name ="userId") int userId) {
		UserDTO userDTO = userService.getUserById(userId);
		return userDTO;
	}
	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addUser(@RequestBody UserDTO userDTO) {
		userService.addUser(userDTO);
	}
}
