package barbearia.api.controller;

import barbearia.api.domain.dto.DadosLogin;
import barbearia.api.domain.dto.TokenJWT;
import barbearia.api.domain.entity.Usuario;
import barbearia.api.domain.service.TokenService;
import barbearia.api.domain.service.ValidadorService;
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
@RequestMapping("/authenticacao/user")
public class AuthenticacaoUserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private ValidadorService validadorService;

	@PostMapping
	public ResponseEntity athenticaUser(@RequestBody @Valid DadosLogin dadosLogin) {

			validadorService.validateOfPasswordUser(dadosLogin.senha(), dadosLogin.login());

			var authenticacaoToken = new UsernamePasswordAuthenticationToken(dadosLogin.login(), dadosLogin.senha());
			var authentication = authenticationManager.authenticate(authenticacaoToken);
			var token = tokenService.gerarTokenUser((Usuario) authentication.getPrincipal());

			return ResponseEntity.ok(new TokenJWT(token));
	}
}
