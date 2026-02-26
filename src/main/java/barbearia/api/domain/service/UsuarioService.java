package barbearia.api.domain.service;

import barbearia.api.domain.Tipo;
import barbearia.api.domain.dto.Email;
import barbearia.api.domain.dto.ListaDeUsuariosDTO;
import barbearia.api.domain.dto.UsuarioDTO;
import barbearia.api.domain.entity.Usuario;
import barbearia.api.domain.repository.UsuarioRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EmailService email;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public void salvaCadastroUsuario(UsuarioDTO usuarioDTO) {
		try {
			Usuario usuario = new Usuario(usuarioDTO);
			usuario.setSenha(passwordEncoder.encode(usuarioDTO.senha()));

			Email confirmaEmail = new Email(usuario.getLogin(), "Cadastro Realizado");

			email.envioDeEmail(confirmaEmail);

			if(usuario.getTipo() == Tipo.CLIENTE){
				usuario.setTipo(Tipo.CLIENTE);
			}else {
				usuario.setTipo(Tipo.BARBEIRO);
			}

			usuarioRepository.save(usuario); //remover essa linha - usuario deve ser salvo após a confirmação do email...
		} catch (MessagingException e) {
			e.getMessage();
		}
	}
	public List<ListaDeUsuariosDTO> listagemUsuarios() {
		return usuarioRepository.findAll().stream().map(ListaDeUsuariosDTO::new).toList();
	}
}


