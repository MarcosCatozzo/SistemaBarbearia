package barbearia.api.infra.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity authenticateUserException(Exception ex) {

		ResponseError response = new ResponseError(ex.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return ResponseEntity.badRequest().body(response);
	}

}
