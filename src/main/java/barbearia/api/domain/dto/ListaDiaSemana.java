package barbearia.api.domain.dto;

import barbearia.api.domain.entity.DiaSemana;

public record ListaDiaSemana(String diaSemana) {

	public ListaDiaSemana(DiaSemana diaSemana){
		this(diaSemana.getDia());
	}
}
