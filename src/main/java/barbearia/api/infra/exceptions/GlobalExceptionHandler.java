package barbearia.api.infra.Exceptions;

import barbearia.api.infra.Exceptions.validadores.ValidaIdException;
import barbearia.api.infra.Exceptions.validadores.ValidaUsuarioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity authenticateUserException(Exception ex) {
		ResponseError response = new ResponseError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
		return ResponseEntity.status(500).body(response);
	}

	@ExceptionHandler(ValidaIdException.class)
	public ResponseEntity validação(ValidaIdException ex){
		ResponseError erro = new ResponseError(ex.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY.value(),LocalDateTime.now());
		return ResponseEntity.status(422).body(erro);
	}

	@ExceptionHandler(ValidaUsuarioException.class)
	public ResponseEntity validaIdBanco(ValidaUsuarioException ex){
		ResponseError responseError = new ResponseError(ex.getMessage(),HttpStatus.NOT_FOUND.value(),LocalDateTime.now());
		return ResponseEntity.status(404).body(responseError);
	}
}
