package barbearia.api.domain.service;

import barbearia.api.domain.dto.ListaHorarios;
import barbearia.api.domain.entity.Horas;
import barbearia.api.domain.repository.HorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {

	@Autowired
	public HorasRepository horasRepository;

	public List<ListaHorarios> listaDeHorarios(){
		List<ListaHorarios> listarHorarios = horasRepository.findAll()
				.stream()
				.map(ListaHorarios::new)
				.toList();

		return listarHorarios;
	}
}
