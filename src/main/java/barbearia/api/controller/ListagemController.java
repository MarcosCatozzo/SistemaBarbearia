package barbearia.api.controller;

import barbearia.api.domain.dto.*;
import barbearia.api.domain.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	public ResponseEntity<List<ListaAgendamentosCliente>> listarAgendamentos(){
		List listaAgendamentoUsuario = agendamentoService.listaDeAgendamentosUsuario();
		return ResponseEntity.ok(listaAgendamentoUsuario);
	}

	@GetMapping("/agendamento/clientes/{id}")
	public ResponseEntity<List<ListaAgendamentosCliente>> listaAgendamentosClientes(@PathVariable Long id){
		List agendamentoClientes = agendamentoService.agendamentosClientes(id);
		return ResponseEntity.ok(agendamentoClientes);
	}
}
