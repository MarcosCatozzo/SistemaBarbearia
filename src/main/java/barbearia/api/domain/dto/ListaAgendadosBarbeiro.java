//package barbearia.api.domain.dto;
//
//import barbearia.api.domain.entity.Agendamento;
//
//import java.time.LocalTime;
//
//public record ListaAgendadosBarbeiro(
//		String nome,
//		String Servico,
//		String dia,
//		LocalTime horario
//) {
//
//	public ListaAgendadosBarbeiro(Agendamento agendamento){
//		this(agendamento.getCliente().getNome(),
//				agendamento.getServico().getNomeServico(),
//				agendamento.getDiaDaSemana().getDia(),
//				agendamento.getHorario().getHorario());
//	}
//
//}
