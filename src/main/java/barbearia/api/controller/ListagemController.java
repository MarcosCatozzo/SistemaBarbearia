package barbearia.api.controller;

import barbearia.api.domain.dto.ListaDeBarbeirosDTO;
import barbearia.api.domain.dto.ListaDeServicosDTO;
import barbearia.api.domain.dto.ListaDeUsuariosDTO;
import barbearia.api.domain.repository.BarbeiroRepository;
import barbearia.api.domain.repository.ServicoRepository;
import barbearia.api.domain.repository.UsuarioRepository;
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
	public ServicoRepository servicoRepository;
	@Autowired
	public UsuarioRepository usuarioRepository;
	@Autowired
	public BarbeiroRepository barbeiroRepository;

	@GetMapping("/servicos")
	public ResponseEntity<List<ListaDeServicosDTO>> listarServicos(){
		List listagemServicos = servicoRepository.findAll().stream().map(ListaDeServicosDTO::new).toList();
		return ResponseEntity.ok(listagemServicos);
	}

	@GetMapping("/usuarios")
	public ResponseEntity<List<ListaDeUsuariosDTO>> listarUsuarios(){
		List listagemUsuarios = usuarioRepository.findAll().stream().map(ListaDeUsuariosDTO::new).toList();
		return ResponseEntity.ok(listagemUsuarios);
	}

	@GetMapping("/barbeiros")
	public ResponseEntity<List<ListaDeBarbeirosDTO>> listarBarbeiros(){
		List listagemBarbeiros = barbeiroRepository.findAll().stream().map(ListaDeBarbeirosDTO::new).toList();
		return ResponseEntity.ok(listagemBarbeiros);
	}
}
