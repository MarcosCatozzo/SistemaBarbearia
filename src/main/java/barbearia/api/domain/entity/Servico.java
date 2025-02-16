package barbearia.api.domain.entity;

import barbearia.api.domain.dto.ServicosDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Servicos")
public class Servico {

	public Servico() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME_SERVICO")
	private String nomeDoServico;

	@Column(name = "VALOR")
	private Double valorDoServico;

	public Servico(ServicosDto servicosDto) {
		this.nomeDoServico = servicosDto.nomeDoServico();
		this.valorDoServico = servicosDto.valorDoServico();
	}

	public String getNomeDoServico() {
		return nomeDoServico;
	}

	public Double getValorDoServico() {
		return valorDoServico;
	}
}
