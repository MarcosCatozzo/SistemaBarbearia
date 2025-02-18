package barbearia.api.domain.service;

import barbearia.api.domain.dto.ServicosDto;
import barbearia.api.domain.entity.Servico;
import barbearia.api.domain.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastraServicoService {

	@Autowired
	private ServicoRepository servicoRepository;

	public Servico CadastraServico(ServicosDto servicosDto){
		return servicoRepository.save(new Servico(servicosDto));
	}
}
