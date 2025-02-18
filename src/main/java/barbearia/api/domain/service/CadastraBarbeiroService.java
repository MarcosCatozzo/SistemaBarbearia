package barbearia.api.domain.service;

import barbearia.api.domain.dto.BarbeiroDto;
import barbearia.api.domain.entity.Barbeiro;
import barbearia.api.domain.repository.BarbeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastraBarbeiroService {

	@Autowired
	private BarbeiroRepository barbeiroRepository;

	public Barbeiro SalvaCadastroBarbeiro(BarbeiroDto barbeiroDto){
		return barbeiroRepository.save(new Barbeiro(barbeiroDto));
	}
}
