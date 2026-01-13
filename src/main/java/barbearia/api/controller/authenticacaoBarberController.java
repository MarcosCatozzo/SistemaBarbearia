package barbearia.api.controller;

import barbearia.api.domain.dto.DadosLogin;
import barbearia.api.domain.dto.TokenJWT;
import barbearia.api.domain.entity.Barbeiro;
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
@RequestMapping("/authenticacao/barber")
public class authenticacaoBarberController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private ValidadorService validadorService;

	@PostMapping
	public ResponseEntity athenticaBarber(@RequestBody @Valid DadosLogin dadosLogin) {

		validadorService.validateOfPasswordBarber(dadosLogin.senha(), dadosLogin.login());

		var authenticacaoToken = new UsernamePasswordAuthenticationToken(dadosLogin.login(), dadosLogin.senha());
		var authentication = authenticationManager.authenticate(authenticacaoToken);
		var token = tokenService.gerarTokenBarber((Barbeiro) authentication.getPrincipal());

		return ResponseEntity.ok(new TokenJWT(token));
	}


}