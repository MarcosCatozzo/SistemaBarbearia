package barbearia.api.domain.dto;

import jakarta.validation.constraints.NotNull;

public record AgendamentoDTO(
		@NotNull
		Long idUsuarios,
		@NotNull
		Long idBarbeiro,

		@NotNull
		Long idServico,

		@NotNull
		Long idHorario,

		@NotNull
		Long idDiaSemana
) {
}
