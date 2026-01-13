package barbearia.api.infra.Exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ResponseError(
		String message,
		HttpStatus statusCode,
		LocalDateTime time) {
}
