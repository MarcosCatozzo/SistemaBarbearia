//package barbearia.api.infra.provider;
//
//import barbearia.api.domain.entity.Barbeiro;
//import barbearia.api.domain.service.BarbeiroDatailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import org.springframework.security.core.Authentication;
//
//@Component
//public class BarberAuthenticateProvider implements AuthenticationProvider {
//		@Autowired
//		private BarbeiroDatailsService barbeiroDetailsService;
//
//		@Autowired
//		private PasswordEncoder passwordEncoder;
//
////		@Override
////		public Authentication authenticate(Authentication authentication) {
////
////			String login = authentication.getName();
////			String senha = authentication.getCredentials().toString();
////
////			Barbeiro barbeiro = (Barbeiro) barbeiroDetailsService.loadUserByUsername(login);
////
////			if (!passwordEncoder.matches(senha, barbeiro.getPassword())) {
////				throw new BadCredentialsException("Senha inválida");
////			}
////
////			return new UsernamePasswordAuthenticationToken(
////					barbeiro,
////					null,
////					barbeiro.getAuthorities()
////			);
////		}
//
//		@Override
//		public boolean supports(Class<?> authentication) {
//			return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
//		}
//	}
