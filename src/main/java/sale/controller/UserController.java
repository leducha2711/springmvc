package sale.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sale.model.UserDTO;
import sale.service.UserService;
import sale.validator.UserValidator;

@Controller
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserValidator userValidator ;
	
	@RequestMapping(value= "/danh-sach-khach-hang", method = RequestMethod.GET)
	public String listUsers(HttpServletRequest request) {
		logger.error("thong tin khach hang");
		List<UserDTO> users = userService.getAllUser();
		request.setAttribute("users", users);
		return "listUsers";
	}
	

	@RequestMapping(value = "/chi-tiet-khach-hang/{userId}", method = RequestMethod.GET)
	public String viewUser(HttpServletRequest request,
			@PathVariable(name ="userId") int userId) {
		request.setAttribute("user", userService.getUserById(userId));
		return "viewUser";
	}
	
	@RequestMapping(value = "/them-khach-hang", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request) {
		request.setAttribute("user", new UserDTO());
		return "addUser";
	}
	@RequestMapping(value = "/them-khach-hang", method = RequestMethod.POST)
	public String addUser(HttpServletRequest request, @ModelAttribute("user")UserDTO userDTO, 
			BindingResult bindingResult) {
		userValidator.validate(userDTO, bindingResult);
		if(bindingResult.hasErrors()) {
			return "addUser";
		}
		userService.addUser(userDTO);
		return "redirect:/danh-sach-khach-hang";
	}
	
	@RequestMapping(value = "/sua-khach-hang/{userId}", method = RequestMethod.GET)
	public String editUser(HttpServletRequest request,@PathVariable(name="userId")int userId) {
		request.setAttribute("user", userService.getUserById(userId));
		return "editUser";
	}
	@RequestMapping(value = "/sua-khach-hang", method = RequestMethod.POST)
	public String editUser(HttpServletRequest request, @ModelAttribute("user")UserDTO userDTO, 
			BindingResult bindingResult) {
		userValidator.validate(userDTO, bindingResult);
		if(bindingResult.hasErrors()) {
			return "editUser";
		}
		userService.updateUser(userDTO);
		return "redirect:/danh-sach-khach-hang";
	}
	
	@RequestMapping(value = "/xoa-khach-hang/{userId}", method = RequestMethod.GET)
	public String deleteUser(HttpServletRequest request,@PathVariable(name="userId")int userId) {
		userService.delete(userId);
		return "redirect:/danh-sach-khach-hang";
	}
}
