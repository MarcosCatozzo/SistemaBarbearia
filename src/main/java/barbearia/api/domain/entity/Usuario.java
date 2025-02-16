package barbearia.api.domain.entity;

import barbearia.api.domain.dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Table(name="Usuarios")
public class Usuario {

	public Usuario(){}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "ID")
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name= "EMAIL")
	private String email;

	@Column(name= "CPF")
	private String cpf;


	public Usuario(UsuarioDTO usuarioDTO) {
		this.nome = usuarioDTO.nome();
		this.cpf = usuarioDTO.cpf();
		this.email = usuarioDTO.email();
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}
}
