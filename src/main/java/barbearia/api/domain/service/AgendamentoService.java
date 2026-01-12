package barbearia.api.domain.service;

import barbearia.api.domain.dto.AgendamentoDTO;
import barbearia.api.domain.entity.*;
import barbearia.api.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

	@Autowired
	public BarbeiroRepository barbeiroRepository;

	@Autowired
	public UsuarioRepository usuarioRepository;

	@Autowired
	public ServicoRepository servicoRepository;

	@Autowired
	public AgendamentoRepository agendamentoRepository;

	@Autowired
	public HorasRepository horasRepository;

	@Autowired
	public DiaSemanaRepository diaSemanaRepository;

	public void agendamento(AgendamentoDTO agendamentoDTO) {

		if (!usuarioRepository.existsById(agendamentoDTO.idUsuarios())) {
			throw new RuntimeException("Usuario não cadastrado");
		}

		if (!barbeiroRepository.existsById(agendamentoDTO.idBarbeiro())) {
			throw new RuntimeException("Barbeiro não cadastrado");
		}

		if(agendamentoRepository.existsByBarbeiro_IdAndDiaDaSemana_IdAndHorario_Id(agendamentoDTO.idBarbeiro(),agendamentoDTO.idDiaSemana(), agendamentoDTO.idHorario())){
			throw new RuntimeException("agendamento já marcado");
		}

		Usuario usuario = usuarioRepository.getReferenceById(agendamentoDTO.idUsuarios());
		Barbeiro barbeiro = barbeiroRepository.getReferenceById(agendamentoDTO.idBarbeiro());
		Servico servico = servicoRepository.getReferenceById(agendamentoDTO.idServico());
		Horas horas = horasRepository.getReferenceById(agendamentoDTO.idHorario());
		DiaSemana diaSemana = diaSemanaRepository.getReferenceById(agendamentoDTO.idDiaSemana());

		var agendamentoMarcado = new Agendamento(null,usuario,barbeiro,servico,diaSemana,horas);

		agendamentoRepository.save(agendamentoMarcado);
	}
}
