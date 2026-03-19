package barbearia.api.domain.service;

import barbearia.api.domain.dto.ListaDiaSemana;
import barbearia.api.domain.entity.DiaSemana;
import barbearia.api.domain.repository.DiaSemanaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiasSemanaService {

	@Autowired
	public DiaSemanaRepository diaSemanaRepository;

	public List<ListaDiaSemana> listagemDiaSemana(){
		List<ListaDiaSemana> listagemDiaDaSemana = diaSemanaRepository.findAll()
				.stream()
				.map(ListaDiaSemana::new)
				.toList();

		return listagemDiaDaSemana;
	}

	public DiaSemana validaDiaSemana(Long id){
		DiaSemana diaSemana = diaSemanaRepository.findById(id).
				orElseThrow(() -> new RuntimeException("ID DA SEMANA NÃO LOCALIZADO"));
		return diaSemana;
	}
}
