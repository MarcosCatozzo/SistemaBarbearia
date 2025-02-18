package barbearia.api.controller;

import barbearia.api.domain.dto.BarbeiroDto;
import barbearia.api.domain.dto.ServicosDto;
import barbearia.api.domain.dto.UsuarioDTO;
import barbearia.api.domain.entity.Barbeiro;
import barbearia.api.domain.entity.Servico;
import barbearia.api.domain.entity.Usuario;
import barbearia.api.domain.service.CadastraBarbeiroService;
import barbearia.api.domain.service.CadastraServicoService;
import barbearia.api.domain.service.CadastraUsuarioService;
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
	public CadastraUsuarioService cadastraUsuarioService;

	@Autowired
	public CadastraBarbeiroService cadastraBarbeiroService;

	@Autowired
	public CadastraServicoService cadastraServicoService;

	@PostMapping("/usuario")
	public ResponseEntity cadastraUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
		Usuario salva = cadastraUsuarioService.SalvaCadastroUsuario(usuarioDTO);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/barbeiro")
	public ResponseEntity cadastraBarbeiro(@RequestBody @Valid BarbeiroDto barbeiroDto){
		Barbeiro salva = cadastraBarbeiroService.SalvaCadastroBarbeiro(barbeiroDto);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/servico")
	public ResponseEntity cadastraServiço(@RequestBody @Valid ServicosDto servicosDto){
		Servico salva = cadastraServicoService.CadastraServico(servicosDto);
		return ResponseEntity.ok().build();
	}
}
