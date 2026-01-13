package barbearia.api.domain.service;

import barbearia.api.domain.repository.BarbeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BarbeiroDatailsService implements UserDetailsService {

	@Autowired
	private BarbeiroRepository barbeiroRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		var barbeiro = barbeiroRepository.findByLogin(username);
		if (barbeiro == null){
			throw new UsernameNotFoundException("Usuário não encontrado: " + username);
		}
		return barbeiro;
	}
}