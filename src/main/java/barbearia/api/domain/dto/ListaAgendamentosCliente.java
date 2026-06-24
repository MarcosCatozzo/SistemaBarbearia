package barbearia.api.domain.dto;

import barbearia.api.domain.entity.Agendamento;

import java.time.LocalTime;

public record ListaAgendamentosCliente(
		String barbeiro,
		String servico,
		String diaSemana,
		LocalTime horarioAgendado
) {

	public ListaAgendamentosCliente(Agendamento agendamento) {
		this(
				agendamento.getBarbeiro().getNome(),
				agendamento.getServico().getNomeServico(),
				agendamento.getDiaSemana().getDia(),
				agendamento.getHorario().getHorario());
	}

}
