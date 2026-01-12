package barbearia.api.domain.dto;

import barbearia.api.domain.entity.Horas;

import java.time.LocalTime;

public record ListaHorarios(LocalTime horario) {
	public ListaHorarios(Horas horas){
		this(horas.getHorario());
	}
}
