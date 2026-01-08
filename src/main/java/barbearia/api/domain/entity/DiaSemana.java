package barbearia.api.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "dia_semana")
@Entity
@Data
public class DiaSemana {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "dia")
	private Long diaSemana;
}
