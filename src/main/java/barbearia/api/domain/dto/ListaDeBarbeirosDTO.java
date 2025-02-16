package barbearia.api.domain.dto;

import barbearia.api.domain.entity.Barbeiro;

public record ListaDeBarbeirosDTO(String nome, String email, String telefone) {

	public ListaDeBarbeirosDTO(Barbeiro barbeiro){
		this(barbeiro.getNome(), barbeiro.getEmail(), barbeiro.getTelefone());
	}
}
