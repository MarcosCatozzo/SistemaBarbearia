package barbearia.api.domain.entity;

import barbearia.api.domain.dto.BarbeiroDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "barbeiro")
public class Barbeiro {
	public Barbeiro(){

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "CPF")
	private String cpf;

	@Column(name= "TELEFONE")
	private String telefone;

	public Barbeiro(BarbeiroDto barbeiroDto) {
		this.nome = barbeiroDto.nome();
		this.cpf = barbeiroDto.cpf();
		this.email = barbeiroDto.email();
		this.telefone = barbeiroDto.telefone();
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}
}
