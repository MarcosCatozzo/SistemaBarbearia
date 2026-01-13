package barbearia.api.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BarbeiroDto(
		@NotBlank
		String nome,
		@NotBlank
		String senha,
		@Email
		@NotNull
		String login,
		@NotBlank
		String telefone,
		@NotBlank
		String cpf
) {
}
