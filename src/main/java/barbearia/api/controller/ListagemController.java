package barbearia.api.controller;

import barbearia.api.domain.dto.*;
import barbearia.api.domain.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public DiasSemanaService diasSemanaService;
	@Autowired
	public HorarioService horarioService;

	@Autowired
	public AgendamentoService agendamentoService;

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

	@GetMapping("/dia_semana")
	public ResponseEntity<List<ListaDiaSemana>> ListaDiaSemana(){
		List diasDaSemana = diasSemanaService.listagemDiaSemana();
		return ResponseEntity.ok(diasDaSemana);
	}

	@GetMapping("/horarios")
	public ResponseEntity<List<ListaHorarios>> listarHorarios(){
		List listaDeHorarios = horarioService.listaDeHorarios();
		return ResponseEntity.ok(listaDeHorarios);
	}

	@GetMapping("/agendamentos")
	public ResponseEntity<List<ListaAgendamentosUsuario>> listarAgendamentos(){
		List listaAgendamentoUsuario = agendamentoService.listaDeAgendamentosUsuario();
		return ResponseEntity.ok(listaAgendamentoUsuario);
	}

//	@GetMapping("/agendado/{id}")
//	public ResponseEntity<List<ListaAgendadosBarbeiro>> listaAgendados(@PathVariable Long id){
//		List agendadosBarbeiro = agendamentoService.agendamentoBarbeiro(id);
//		return ResponseEntity.ok(agendadosBarbeiro);
//	}
}
