package barbearia.api.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Table(name = "horarios")
@Data
@Entity
public class Horas {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "horario")
	private LocalTime horario;

	public LocalTime getHorario() {
		return horario;
	}
}
