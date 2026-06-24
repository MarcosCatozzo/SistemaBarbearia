package barbearia.api.domain.dto;

import barbearia.api.domain.Tipo;
import barbearia.api.domain.entity.Usuario;

public record ListaDeUsuariosDTO(String nome, String email, Tipo tipo) {

	public ListaDeUsuariosDTO(Usuario usuario){
		this(usuario.getNome(), usuario.getLogin(), usuario.getTipo());
	}
}
