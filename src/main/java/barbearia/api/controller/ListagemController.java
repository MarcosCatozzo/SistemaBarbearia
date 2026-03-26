package barbearia.api.controller;

import barbearia.api.domain.dto.*;
import barbearia.api.domain.service.*;
import io.swagger.v3.oas.annotations.Operation;
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

	@Operation(summary = "Lista os serviços")
	@GetMapping("/servicos")
	public ResponseEntity<List<ListaDeServicosDTO>> listarServicos(){
		List listagemServicos = servicoService.listaServicos();
		return ResponseEntity.ok(listagemServicos);
	}

	@Operation(summary = "Lista todos os usuários do sistema")
	@GetMapping("/usuarios")
	public ResponseEntity<List<ListaDeUsuariosDTO>> listarUsuarios(){
		List listagemUsuarios = usuarioService.listagemUsuarios();
		return ResponseEntity.ok(listagemUsuarios);
	}

	@Operation(summary = "Lista todos os dias da semana")
	@GetMapping("/dia_semana")
	public ResponseEntity<List<ListaDiaSemana>> ListaDiaSemana(){
		List diasDaSemana = diasSemanaService.listagemDiaSemana();
		return ResponseEntity.ok(diasDaSemana);
	}

	@Operation(summary = "Lista todos os horários disponíveis")
	@GetMapping("/horarios")
	public ResponseEntity<List<ListaHorarios>> listarHorarios(){
		List listaDeHorarios = horarioService.listaDeHorarios();
		return ResponseEntity.ok(listaDeHorarios);
	}

	@Operation(summary = "Lista todos os agendamentos")
	@GetMapping("/agendamentos")
	public ResponseEntity<List<ListaAgendamentosCliente>> listarAgendamentos(){
		List listaAgendamentoUsuario = agendamentoService.listaDeAgendamentosUsuario();
		return ResponseEntity.ok(listaAgendamentoUsuario);
	}

	@Operation(summary = "Lista todos os agendamentos do cliente")
	@GetMapping("/agendamento/clientes/{id}")
	public ResponseEntity<List<ListaAgendamentosCliente>> listaAgendamentosClientes(@PathVariable Long id){
		List agendamentoClientes = agendamentoService.agendamentosClientes(id);
		return ResponseEntity.ok(agendamentoClientes);
	}

	@Operation(summary = "Lista todos os agendamentos do barbeiro")
	@GetMapping("/agendamento/barbeiros/{id}")
	public ResponseEntity<List<ListaAgendamentoBarbeiros>> listaAgendamentosBarbeiros(@PathVariable Long id){
		List<ListaAgendamentoBarbeiros> agendamentoBarbeiros = agendamentoService.agendamentosBarbeiro(id);
		return ResponseEntity.ok(agendamentoBarbeiros);
	}
}
