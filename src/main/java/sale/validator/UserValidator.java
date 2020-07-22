package sale.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sale.model.UserDTO;

@Component
public class UserValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserDTO.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		UserDTO userDTO = (UserDTO) target;
		
		if(userDTO.getName()==null || userDTO.getName().length()==0) {
			errors.rejectValue("name", "field.required");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "field.required");
		if(userDTO.getPassword().length()<6||userDTO.getPassword().length()>12) {
			errors.rejectValue("password", "password.invalid");
		}
		if(!userDTO.getPhone().matches("^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$")) {
			errors.rejectValue("phone", "phone.invalid");
		}
	}

}
