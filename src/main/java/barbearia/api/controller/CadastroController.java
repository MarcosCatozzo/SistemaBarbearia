package barbearia.api.controller;

import barbearia.api.domain.dto.BarbeiroDto;
import barbearia.api.domain.dto.ServicosDto;
import barbearia.api.domain.dto.UsuarioDTO;
import barbearia.api.domain.entity.Barbeiro;
import barbearia.api.domain.entity.Servico;
import barbearia.api.domain.entity.Usuario;
import barbearia.api.domain.service.BarbeiroService;
import barbearia.api.domain.service.ServicoService;
import barbearia.api.domain.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastrar")
public class CadastroController {

	@Autowired
	public UsuarioService usuarioService;

	@Autowired
	public BarbeiroService barbeiroService;

	@Autowired
	public ServicoService servicoService;

	@PostMapping("/usuario")
	public ResponseEntity cadastraUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
		Usuario salva = usuarioService.salvaCadastroUsuario(usuarioDTO);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/barbeiro")
	public ResponseEntity cadastraBarbeiro(@RequestBody @Valid BarbeiroDto barbeiroDto) {
		Barbeiro salva = barbeiroService.salvaCadastroBarbeiro(barbeiroDto);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/servico")
	public ResponseEntity cadastraServiço(@RequestBody @Valid ServicosDto servicosDto) {
		Servico salva = servicoService.cadastraServico(servicosDto);
		return ResponseEntity.ok().build();
	}
}
