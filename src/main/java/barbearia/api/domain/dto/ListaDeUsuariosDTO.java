package barbearia.api.domain.dto;

import barbearia.api.domain.entity.Usuario;

public record ListaDeUsuariosDTO(String nome, String email) {

	public ListaDeUsuariosDTO(Usuario usuario){
		this(usuario.getNome(), usuario.getEmail());
	}
}
