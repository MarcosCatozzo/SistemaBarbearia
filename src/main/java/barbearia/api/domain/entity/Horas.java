package barbearia.api.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "horarios")
@Data
@Entity
public class Horas {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "horario")
	private Long horarioId;
}
