package barbearia.api.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "agendamento")
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
}
