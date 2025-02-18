package barbearia.api.domain.service;

import barbearia.api.domain.dto.UsuarioDTO;
import barbearia.api.domain.entity.Usuario;
import barbearia.api.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastraUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario SalvaCadastroUsuario(UsuarioDTO usuarioDTO){
		return usuarioRepository.save(new Usuario(usuarioDTO));
	}
}


