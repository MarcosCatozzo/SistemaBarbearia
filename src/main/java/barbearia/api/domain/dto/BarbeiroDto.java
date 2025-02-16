package barbearia.api.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BarbeiroDto(
		@NotBlank
		String nome,
		@NotBlank
		String cpf,
		@Email
		@NotNull
		String email,
		@NotBlank
		String telefone
) {
}
