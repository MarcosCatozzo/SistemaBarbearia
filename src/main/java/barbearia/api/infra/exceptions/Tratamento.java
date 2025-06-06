package barbearia.api.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Tratamento {
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity erro404(){
		return ResponseEntity.badRequest().build();
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity erro400(MethodArgumentNotValidException e){
		var erro = e.getFieldError();
		return ResponseEntity.badRequest().body(e.getMessage());
	}


}
