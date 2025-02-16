package barbearia.api.domain.controller;

import barbearia.api.domain.dto.BarbeiroDto;
import barbearia.api.domain.dto.ServicosDto;
import barbearia.api.domain.dto.UsuarioDTO;
import barbearia.api.domain.entity.Barbeiro;
import barbearia.api.domain.entity.Servico;
import barbearia.api.domain.entity.Usuario;
import barbearia.api.domain.repository.BarbeiroRepository;
import barbearia.api.domain.repository.ServicoRepository;
import barbearia.api.domain.repository.UsuarioRepository;
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
	public UsuarioRepository usuarioRepository;

	@Autowired
	public BarbeiroRepository barbeiroRepository;

	@Autowired
	public ServicoRepository servicoRepository;

	@PostMapping("/usuario")
	public ResponseEntity cadastraUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
		Usuario salva = usuarioRepository.save(new Usuario(usuarioDTO));
		return ResponseEntity.ok().build();
	}

	@PostMapping("/barbeiro")
	public ResponseEntity cadastraBarbeiro(@RequestBody @Valid BarbeiroDto barbeiroDto){
		Barbeiro salva = barbeiroRepository.save(new Barbeiro(barbeiroDto));
		return ResponseEntity.ok().build();
	}

	@PostMapping("/servico")
	public ResponseEntity cadastraServiço(@RequestBody @Valid ServicosDto servicosDto){
		Servico salva = servicoRepository.save(new Servico(servicosDto));
		return ResponseEntity.ok().build();
	}
}
