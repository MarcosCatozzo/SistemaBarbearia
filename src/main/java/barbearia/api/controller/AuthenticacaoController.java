package barbearia.api.controller;

import barbearia.api.domain.dto.DadosLogin;
import barbearia.api.domain.dto.TokenJWT;
import barbearia.api.domain.entity.Login;
import barbearia.api.domain.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Authenticacao")
public class AuthenticacaoController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity athenticaUser(@RequestBody @Valid DadosLogin dadosLogin) {
			var authenticacaoToken = new UsernamePasswordAuthenticationToken(dadosLogin.login(), dadosLogin.senha());
			var authentication = authenticationManager.authenticate(authenticacaoToken);
			var token = tokenService.gerarToken((Login) authentication.getPrincipal());
			return ResponseEntity.ok(new TokenJWT(token));
	}
}
