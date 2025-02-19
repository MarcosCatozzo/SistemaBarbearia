package barbearia.api.domain.service;

import barbearia.api.domain.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

	@Autowired
	public AgendamentoRepository agendamentoRepository;
}
