package barbearia.api.domain.entity;

import barbearia.api.domain.dto.AgendamentoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "agendamento")
@EqualsAndHashCode(of = "id")
public class Agendamento {

	public Agendamento(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	public Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "barbeiro_id", nullable = false)
	public Usuario barbeiro;

	@ManyToOne
	@JoinColumn(name = "servico_id", nullable = false)
	public Servico servico;

	@ManyToOne
	@JoinColumn(name = "diaSemana_id", nullable = false)
	public DiaSemana diaSemana;

	@ManyToOne
	@JoinColumn(name = "horario_id", nullable = false)
	public Horas horario;

	public Agendamento( Long id, Usuario cliente, Usuario barbeiro, Servico servico, DiaSemana diaSemana, Horas horas) {
		this.id = id;
		this.usuario = cliente;
		this.barbeiro = barbeiro;
		this.servico = servico;
		this.diaSemana = diaSemana;
		this.horario = horas;
	}
}
