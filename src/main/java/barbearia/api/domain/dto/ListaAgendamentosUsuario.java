//package barbearia.api.domain.dto;
//
//import barbearia.api.domain.entity.Agendamento;
//
//import java.time.LocalTime;
//
//public record ListaAgendamentosUsuario(
//		String barbeiro,
//		String servico,
//		String diaSemana,
//		LocalTime horarioAgendado
//) {
//
//	public ListaAgendamentosUsuario(Agendamento agendamento){
//		this(agendamento.getBarbeiro().getNome(),
//				agendamento.getServico().getNomeServico(),
//				agendamento.getDiaDaSemana().getDia(),
//				agendamento.getHorario().getHorario());
//	}
//
//}
