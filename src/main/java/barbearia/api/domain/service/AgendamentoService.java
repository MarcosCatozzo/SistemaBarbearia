package barbearia.api.domain.service;

import barbearia.api.domain.dto.AgendamentoDTO;
import barbearia.api.domain.entity.*;
import barbearia.api.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

	@Autowired
	public UsuarioRepository usuarioRepository;

	@Autowired
	public ServicoRepository servicoRepository;

	@Autowired
	public HorarioService horarioService;

	@Autowired
	public ServicoService servicoService;

	@Autowired
	public AgendamentoRepository agendamentoRepository;

	@Autowired
	public DiasSemanaService diasSemanaService;

	@Autowired
	public DiaSemanaRepository diaSemanaRepository;

	public void agendamento(AgendamentoDTO agendamentoDTO) {

		Usuario cliente = usuarioRepository.findById(agendamentoDTO.idUsuarios())
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

		Usuario barbeiro = usuarioRepository.findById(agendamentoDTO.idBarbeiro())
				.orElseThrow(() -> new RuntimeException("Barbeiro não encontrado"));

		Servico servico = servicoService.validaServico(agendamentoDTO.idServico());
		Horas horario = horarioService.validaHorario(agendamentoDTO.idHorario());
		DiaSemana diaSemana = diasSemanaService.validaDiaSemana(agendamentoDTO.idDiaSemana());

		if(agendamentoRepository.existsByUsuario_IdAndDiaSemana_IdAndHorario_Id(agendamentoDTO.idBarbeiro(),agendamentoDTO.idDiaSemana(), agendamentoDTO.idHorario())){
			throw new RuntimeException("agendamento já marcado");
		}
		Agendamento agendamentoMarcado = new Agendamento(null,cliente,barbeiro,servico,diaSemana,horario);

		agendamentoRepository.save(agendamentoMarcado);
	}


//	public List<ListaAgendamentosUsuario> listaDeAgendamentosUsuario(){
//		List listaAgendamentos = agendamentoRepository.findAll()
//				.stream()
//				.map(ListaAgendamentosUsuario::new)
//				.toList();
//
//		return listaAgendamentos;
//	}

}
