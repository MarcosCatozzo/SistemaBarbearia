package barbearia.api.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioDTO(
		@NotBlank
		String nome,
		@NotNull
		@Email
		String login,
		@NotNull
		String telefone,

		@NotNull
		String senha

) {
}
