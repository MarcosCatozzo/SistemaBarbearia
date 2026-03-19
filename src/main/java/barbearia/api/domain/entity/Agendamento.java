package barbearia.api.domain.entity;

import barbearia.api.domain.dto.AgendamentoDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getBarbeiro() {
		return barbeiro;
	}

	public void setBarbeiro(Usuario barbeiro) {
		this.barbeiro = barbeiro;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Horas getHorario() {
		return horario;
	}

	public void setHorario(Horas horario) {
		this.horario = horario;
	}

}
