package barbearia.api.domain.service;

import barbearia.api.domain.dto.BarbeiroDto;
import barbearia.api.domain.dto.ListaDeBarbeirosDTO;
import barbearia.api.domain.entity.Barbeiro;
import barbearia.api.domain.repository.BarbeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbeiroService {

	@Autowired
	private BarbeiroRepository barbeiroRepository;

	public Barbeiro salvaCadastroBarbeiro(BarbeiroDto barbeiroDto){
		return barbeiroRepository.save(new Barbeiro(barbeiroDto));
	}

	public List<ListaDeBarbeirosDTO> listagemBarbeiro(){
		return  barbeiroRepository.findAll().stream().map(ListaDeBarbeirosDTO::new).toList();
	}
}
