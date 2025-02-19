package barbearia.api.domain.service;

import barbearia.api.domain.dto.ListaDeUsuariosDTO;
import barbearia.api.domain.dto.UsuarioDTO;
import barbearia.api.domain.entity.Usuario;
import barbearia.api.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario salvaCadastroUsuario(UsuarioDTO usuarioDTO){
		return usuarioRepository.save(new Usuario(usuarioDTO));
	}


	public List<ListaDeUsuariosDTO> listagemUsuarios(){
		return usuarioRepository.findAll().stream().map(ListaDeUsuariosDTO::new).toList();
	}
}


