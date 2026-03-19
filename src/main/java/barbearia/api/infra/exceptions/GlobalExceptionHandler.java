package barbearia.api.infra.Exceptions;

import jakarta.mail.MessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity authenticateUserException(Exception ex) {
		ResponseError response = new ResponseError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
		return ResponseEntity.internalServerError().body(response);
	}

	@ExceptionHandler(ValidaException.class)
	public ResponseEntity validação(ValidaException ex){
		ResponseError erro = new ResponseError(ex.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY.value(),LocalDateTime.now());
		return ResponseEntity.unprocessableEntity().body(erro);
	}
}
