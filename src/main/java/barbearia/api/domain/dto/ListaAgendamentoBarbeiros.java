package barbearia.api.domain.dto;

import barbearia.api.domain.entity.Agendamento;

import java.time.LocalTime;

public record ListaAgendamentoBarbeiros(
		String Cliente,
		String Servico,
		String diaSemana,
		LocalTime Horario
) {
	public ListaAgendamentoBarbeiros(Agendamento agendamento){
		this(
				agendamento.getCliente().getNome(),
				agendamento.getServico().getNomeServico(),
				agendamento.getDiaSemana().getDia(),
				agendamento.getHorario().getHorario()
		);
	}
}
