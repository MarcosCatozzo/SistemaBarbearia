package barbearia.api.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioDTO(
		@NotBlank
		String nome,
		@NotNull
		String cpf,
		@NotNull
		String email

) {
}
