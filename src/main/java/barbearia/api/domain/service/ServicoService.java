package barbearia.api.domain.service;

import barbearia.api.domain.dto.ListaDeServicosDTO;
import barbearia.api.domain.dto.ServicosDto;
import barbearia.api.domain.entity.Servico;
import barbearia.api.domain.repository.ServicoRepository;
import barbearia.api.infra.Exceptions.validadores.ValidaUsuarioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;

	public Servico cadastraServico(ServicosDto servicosDto) {
		return servicoRepository.save(new Servico(servicosDto));
	}

	public List<ListaDeServicosDTO> listaServicos() {
		return servicoRepository.findAll().stream().map(ListaDeServicosDTO::new).toList();
	}

	public Servico validaServico(Long id) {
		Servico servico = servicoRepository.findById(id)
				.orElseThrow(() -> new ValidaUsuarioException("ID DO SERVICO NÃO LOCALIZADO!!"));
		return servico;
	}
}
