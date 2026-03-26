package barbearia.api.domain.service;

import barbearia.api.domain.dto.AgendamentoDTO;
import barbearia.api.domain.dto.ListaAgendamentoBarbeiros;
import barbearia.api.domain.dto.ListaAgendamentosCliente;
import barbearia.api.domain.entity.*;
import barbearia.api.domain.repository.*;
import barbearia.api.infra.Exceptions.validadores.ValidaIdException;
import barbearia.api.infra.Exceptions.validadores.ValidaUsuarioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AgendamentoService {
	@Autowired
	public HorarioService horarioService;

	@Autowired
	public ServicoService servicoService;

	@Autowired
	public AgendamentoRepository agendamentoRepository;

	@Autowired
	public DiasSemanaService diasSemanaService;

	@Autowired
	public UsuarioService usuarioService;

	public void agendamento(AgendamentoDTO agendamentoDTO) {

		if (Objects.equals(agendamentoDTO.idUsuarios(), agendamentoDTO.idBarbeiro())) {
			throw new ValidaIdException("ID DO BARBEIRO E CLIENTE NÃO PODEM SER IGUAIS! ");
		}

		Usuario barbeiro = usuarioService.validaBarbeiro(agendamentoDTO.idBarbeiro());
		Usuario cliente = usuarioService.validaUsuario(agendamentoDTO.idUsuarios());
		Servico servico = servicoService.validaServico(agendamentoDTO.idServico());
		Horas horario = horarioService.validaHorario(agendamentoDTO.idHorario());
		DiaSemana diaSemana = diasSemanaService.validaDiaSemana(agendamentoDTO.idDiaSemana());

		if (agendamentoRepository.existsByCliente_IdAndDiaSemana_IdAndHorario_Id(agendamentoDTO.idBarbeiro(), agendamentoDTO.idDiaSemana(), agendamentoDTO.idHorario())) {
			throw new RuntimeException("agendamento já marcado");
		}
		Agendamento agendamentoMarcado = new Agendamento(null, cliente, barbeiro, servico, diaSemana, horario);

		agendamentoRepository.save(agendamentoMarcado);
	}

	public List<ListaAgendamentosCliente> listaDeAgendamentosUsuario() {
		List listaAgendamentos = agendamentoRepository.findAll()
				.stream()
				.map(ListaAgendamentosCliente::new)
				.toList();

		return listaAgendamentos;
	}

	public List<ListaAgendamentosCliente> agendamentosClientes(Long id) {
		List<ListaAgendamentosCliente> agendamentos = agendamentoRepository.findByCliente_Id(id)
				.stream()
				.map(ListaAgendamentosCliente::new)
				.toList();

		if(agendamentos.isEmpty()){
			throw new ValidaUsuarioException("NAO POSSUI AGENDAMENTO!");
		}else {
			return agendamentos;
		}
	}

	public List<ListaAgendamentoBarbeiros> agendamentosBarbeiro(Long id){
		List<ListaAgendamentoBarbeiros> agendamentos = agendamentoRepository.findByBarbeiro_id(id)
				.stream()
				.map(ListaAgendamentoBarbeiros::new)
				.toList();

		if (agendamentos.isEmpty()){
			throw new ValidaUsuarioException("NAO POSSUI AGENDAMENTO!");
		}else {
			return agendamentos;
		}
	}
}
