package barbearia.api.domain.service;

import barbearia.api.domain.dto.AgendamentoDTO;
import barbearia.api.domain.entity.Agendamento;
import barbearia.api.domain.entity.Barbeiro;
import barbearia.api.domain.entity.Servico;
import barbearia.api.domain.entity.Usuario;
import barbearia.api.domain.repository.AgendamentoRepository;
import barbearia.api.domain.repository.BarbeiroRepository;
import barbearia.api.domain.repository.ServicoRepository;
import barbearia.api.domain.repository.UsuarioRepository;
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

	public Agendamento agendamento(AgendamentoDTO agendamentoDTO){
		if(!usuarioRepository.existsById(agendamentoDTO.idUsuarios())){
			throw new RuntimeException("Usuario não cadastrado");
		}

		if (!barbeiroRepository.existsById(agendamentoDTO.idBarbeiro())){
			throw new RuntimeException("Barbeiro não cadastrado");
		}

		if (!servicoRepository.existsById(agendamentoDTO.idServico())){
			throw new RuntimeException("Servico nao encontrado");
		}

		Usuario usuario = usuarioRepository.getReferenceById(agendamentoDTO.idUsuarios());
		Barbeiro barbeiro = barbeiroRepository.getReferenceById(agendamentoDTO.idBarbeiro());
		Servico servico = servicoRepository.getReferenceById(agendamentoDTO.idServico());

		Agendamento agendamentoMarcado = new Agendamento();
		agendamentoMarcado.setCliente(usuario);
		agendamentoMarcado.setBarbeiro(barbeiro);
		agendamentoMarcado.setServico(servico);
		agendamentoMarcado.setData(agendamentoDTO.data());

		return agendamentoRepository.save(agendamentoMarcado);
	}
}
