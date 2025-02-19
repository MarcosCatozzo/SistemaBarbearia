package barbearia.api.domain.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoDTO(
		@NotNull
		Long idUsuarios,
		@NotNull
		Long idBarbeiro,
		@NotNull
		@Future
		LocalDateTime data
) {
}
