package barbearia.api.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "barbeiro_id")
	private Barbeiro barbeiro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "servico_id")
	private Servico servico;

	private LocalDateTime data;

	public Agendamento(Long id, Usuario usuario, Barbeiro barbeiro, Servico servico, LocalDateTime dataHora) {
		this.id = id;
		this.cliente = usuario;
		this.barbeiro = barbeiro;
		this.servico = servico;
		this.data = dataHora;
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

	public LocalDateTime getData() {
		return data;
	}
}
