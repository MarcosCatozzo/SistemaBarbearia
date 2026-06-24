package barbearia.api.domain.entity;

import barbearia.api.domain.Tipo;
import barbearia.api.domain.dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario implements UserDetails {

	public Usuario() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "email")
	private String login;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "senha")
	private String senha;

	@Column(name = "tipo")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;


	public Usuario(UsuarioDTO usuarioDTO) {
		this.nome = usuarioDTO.nome();
		this.login = usuarioDTO.login();
		this.telefone = usuarioDTO.telefone();
		this.senha = usuarioDTO.senha();
		this.tipo = usuarioDTO.tipo();
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public Long getId(){
		return id;
	}

	public Tipo getTipo(){
		return this.tipo;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setTipo(Tipo tipo){
		this.tipo = tipo;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
