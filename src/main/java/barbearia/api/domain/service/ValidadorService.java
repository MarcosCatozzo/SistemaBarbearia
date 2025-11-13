package barbearia.api.domain.service;

import barbearia.api.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ValidadorService {
	@Autowired
	public BCryptPasswordEncoder crypt;

	@Autowired
	public UsuarioRepository usuarioRepository;

	public Boolean validateOfPassword(String senha, String email) {

		UserDetails confirmaDados = usuarioRepository.findByLogin(email);

		String password = confirmaDados.getPassword();

		Boolean isValid = crypt.matches(senha, password);
		if (!isValid) {
			throw new RuntimeException("A senha está incorreta!");
		}
		return true;
	}
}
