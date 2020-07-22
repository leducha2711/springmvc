package sale.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {
	private static Logger logger = Logger.getLogger(ExceptionController.class);
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = {NoHandlerFoundException.class})
	public String ExceptionHandler(Exception exception) {
		logger.error(exception);
		return "404";
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = {Exception.class})
	public String exceptionAll(Exception exception) {
		logger.error(exception);
		
		return "error";
	}
}
