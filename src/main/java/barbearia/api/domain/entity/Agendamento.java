package barbearia.api.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "agendamento")
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

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public void setBarbeiro(Barbeiro barbeiro) {
		this.barbeiro = barbeiro;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
}
