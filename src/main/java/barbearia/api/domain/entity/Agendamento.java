package barbearia.api.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "agendamento")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "barbeiro_id")
	private Barbeiro barbeiro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "servico_id")
	private Servico servico;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dia_semana_id")
	private DiaSemana diaDaSemana;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "horario_id")
	private Horas horario;

	public Agendamento(Long id, Usuario usuario, Barbeiro barbeiro, Servico servico, DiaSemana diaDaSemana, Horas horario) {
		this.id = id;
		this.cliente = usuario;
		this.barbeiro = barbeiro;
		this.servico = servico;
		this.diaDaSemana = diaDaSemana;
		this.horario = horario;
	}

	public Long getId() {
		return id;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public Barbeiro getBarbeiro() {
		return barbeiro;
	}

	public Servico getServico() {
		return servico;
	}

	public DiaSemana getDiaDaSemana() {
		return diaDaSemana;
	}
}
