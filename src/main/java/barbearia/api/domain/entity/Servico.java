package barbearia.api.domain.entity;

import barbearia.api.domain.dto.ServicosDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "servicos")
public class Servico {

	public Servico() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "nome_servico")
	private String nomeServico;

	@Column(name = "valor_servico")
	private Double valorServico;

	@Column(name = "status")
	private Boolean status;

	public Servico(ServicosDto servicosDto) {
		this.nomeServico = servicosDto.nomeServico();
		this.valorServico = servicosDto.valorServico();
		this.status = servicosDto.status();
	}

	public String getNomeDoServico() {
		return nomeServico;
	}

	public Double getValorDoServico() {
		return valorServico;
	}

	public Boolean getStatus(){
		return status;
	}

	public Long getId() {
		return id;
	}
}
