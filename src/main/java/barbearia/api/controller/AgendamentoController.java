package barbearia.api.controller;

import barbearia.api.domain.dto.AgendamentoDTO;
import barbearia.api.domain.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

	@Autowired
	private AgendamentoService agendamentoService;
	@PostMapping
	public ResponseEntity agendamento(@RequestBody @Valid AgendamentoDTO agendamentoDTO){

	}
}
