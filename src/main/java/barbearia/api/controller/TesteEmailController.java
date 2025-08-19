package barbearia.api.controller;

import barbearia.api.domain.dto.Email;
import barbearia.api.domain.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class TesteEmailController {

	@Autowired
	public EmailService emailService;

	@PostMapping
	public ResponseEntity<?> testeEnvioDeEmail(@RequestBody Email email){
		try {
			emailService.envioDeEmail(email);
			return ResponseEntity.ok("E-mail enviado com sucesso!");
		}catch (Exception e ){
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
}
