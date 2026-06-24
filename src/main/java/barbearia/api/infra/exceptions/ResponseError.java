package barbearia.api.infra.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

public record ResponseError(
		String message,
		int statusCode,
		LocalDateTime time) {
}
