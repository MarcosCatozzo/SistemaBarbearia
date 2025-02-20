package barbearia.api.domain.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoDTO(

		Long idUsuarios,

		Long idBarbeiro,
		@NotNull
		@Future
		LocalDateTime data
) {
}
