package barbearia.api.domain.service;

import barbearia.api.domain.dto.AgendamentoDTO;
import barbearia.api.domain.repository.AgendamentoRepository;
import barbearia.api.domain.repository.BarbeiroRepository;
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

	@Autowired
	public BarbeiroRepository barbeiroRepository;

	@Autowired
	public AgendamentoRepository agendamentoRepository;

	public ValidadorService(BCryptPasswordEncoder crypt) {
		this.crypt = crypt;
	}

	public Boolean validateOfPasswordUser(String senha, String email) {

		UserDetails confirmaDados = usuarioRepository.findByLogin(email);

		String password = confirmaDados.getPassword();

		Boolean isValid = crypt.matches(senha, password);
		if (!isValid) {
			throw new RuntimeException("A senha está incorreta!");
		}
		return true;
	}

	public Boolean validateOfPasswordBarber(String senha, String email) {

		UserDetails confirmaDados = barbeiroRepository.findByLogin(email);

		String password = confirmaDados.getPassword();

		Boolean isValid = crypt.matches(senha, password);
		if (!isValid) {
			throw new RuntimeException("A senha está incorreta!");
		}
		return true;
	}
}
