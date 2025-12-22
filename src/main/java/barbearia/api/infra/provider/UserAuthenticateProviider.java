package barbearia.api.infra.provider;

import barbearia.api.domain.entity.Usuario;
import barbearia.api.domain.service.UserDatailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticateProviider implements AuthenticationProvider {
	@Autowired
	private UserDatailsService usuarioDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) {

		String login = authentication.getName();
		String senha = authentication.getCredentials().toString();

		Usuario usuario = (Usuario) usuarioDetailsService.loadUserByUsername(login);

		if (!passwordEncoder.matches(senha, usuario.getPassword())) {
			throw new BadCredentialsException("Senha inválida");
		}

		return new UsernamePasswordAuthenticationToken(
				usuario,
				null,
				usuario.getAuthorities()
		);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
