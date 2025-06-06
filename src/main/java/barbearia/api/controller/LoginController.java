package barbearia.api.controller;

import barbearia.api.domain.dto.DadosLogin;
import barbearia.api.domain.entity.Login;
import barbearia.api.domain.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	@PostMapping(name = "/login")
	public ResponseEntity login(@RequestBody @Valid DadosLogin dadosLogin){
		Login s = loginService.salvaDados(dadosLogin);
		return ResponseEntity.noContent().build();
	}
}


