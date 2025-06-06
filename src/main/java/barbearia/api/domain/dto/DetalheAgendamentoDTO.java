package barbearia.api.domain.dto;

import barbearia.api.domain.entity.Agendamento;

import java.time.LocalDateTime;

public record DetalheAgendamentoDTO(Long id, Long idUsuario, Long idBarbeiro, Long idServico, LocalDateTime data){

	public DetalheAgendamentoDTO(Agendamento agendamento){
		this(agendamento.getId(), agendamento.getCliente().getId(), agendamento.getBarbeiro().getId(), agendamento.getServico().getId(), agendamento.getData());
	}
}
