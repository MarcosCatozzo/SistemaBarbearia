package barbearia.api.controller;

import barbearia.api.domain.dto.*;
import barbearia.api.domain.repository.DiaSemanaRepository;
import barbearia.api.domain.repository.HorasRepository;
import barbearia.api.domain.service.*;
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

	@Autowired
	public DiasDaSemanaService diasDaSemanaService;

	@Autowired
	public HorarioService horarioService;

	@GetMapping("/servicos")
	public ResponseEntity<List<ListaDeServicosDTO>> listarServicos(){
		List listagemServicos = servicoService.listaServicos();
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

	@GetMapping("/dia_semana")
	public ResponseEntity<List<ListaDiaSemana>> ListaDiaSemana(){
		List diasDaSemana = diasDaSemanaService.listagemDiaSemana();
		return ResponseEntity.ok(diasDaSemana);
	}

	@GetMapping("/horarios")
	public ResponseEntity<List<ListaHorarios>> listarHorarios(){
		List listaDeHorarios = horarioService.listaDeHorarios();
		return ResponseEntity.ok(listaDeHorarios);
	}
}
