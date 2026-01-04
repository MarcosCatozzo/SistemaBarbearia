package barbearia.api.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ServicosDto(
		@NotBlank
		String nomeServico,
		@NotNull
		Double valorServico,
		@NotNull
		Boolean status
) {
}
