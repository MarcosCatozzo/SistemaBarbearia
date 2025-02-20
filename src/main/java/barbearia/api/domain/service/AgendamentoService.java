package barbearia.api.domain.service;

import barbearia.api.domain.dto.AgendamentoDTO;
import barbearia.api.domain.entity.Agendamento;
import barbearia.api.domain.entity.Barbeiro;
import barbearia.api.domain.entity.Usuario;
import barbearia.api.domain.repository.AgendamentoRepository;
import barbearia.api.domain.repository.BarbeiroRepository;
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
	public AgendamentoRepository agendamentoRepository;

	public Agendamento agendamentoCorte(AgendamentoDTO agendamentoDTO){
		if(!usuarioRepository.existsById(agendamentoDTO.idUsuarios())){
			throw new RuntimeException("Usuario não cadastrado");
		}

		if (!barbeiroRepository.existsById(agendamentoDTO.idBarbeiro())){
			throw new RuntimeException("Barbeiro não cadastrado");
		}

		Usuario usuario = usuarioRepository.getReferenceById(agendamentoDTO.idUsuarios());
		Barbeiro barbeiro = barbeiroRepository.getReferenceById(agendamentoDTO.idBarbeiro());

		Agendamento agendamentoMarcado = new Agendamento(null,null,null,agendamentoDTO.data());

		return agendamentoRepository.save(agendamentoMarcado);
	}
}
