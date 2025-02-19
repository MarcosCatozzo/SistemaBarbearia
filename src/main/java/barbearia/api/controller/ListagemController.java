package barbearia.api.controller;

import barbearia.api.domain.dto.ListaDeBarbeirosDTO;
import barbearia.api.domain.dto.ListaDeServicosDTO;
import barbearia.api.domain.dto.ListaDeUsuariosDTO;
import barbearia.api.domain.service.BarbeiroService;
import barbearia.api.domain.service.ServicoService;
import barbearia.api.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lista")
public class ListagemController {
	@Autowired
	public ServicoService servicoService;
	@Autowired
	public UsuarioService usuarioService;
	@Autowired
	public BarbeiroService barbeiroService;

	@GetMapping("/servicos")
	public ResponseEntity<List<ListaDeServicosDTO>> listarServicos(){
		List listagemServicos = servicoService.listagemDeServico();
		return ResponseEntity.ok(listagemServicos);
	}

	@GetMapping("/usuarios")
	public ResponseEntity<List<ListaDeUsuariosDTO>> listarUsuarios(){
		List listagemUsuarios = usuarioService.listagemUsuarios();
		return ResponseEntity.ok(listagemUsuarios);
	}

	@GetMapping("/barbeiros")
	public ResponseEntity<List<ListaDeBarbeirosDTO>> listarBarbeiros(){
		List listagemBarbeiros = barbeiroService.listagemBarbeiro();
		return ResponseEntity.ok(listagemBarbeiros);
	}
}
