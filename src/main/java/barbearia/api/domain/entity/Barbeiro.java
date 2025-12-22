package barbearia.api.domain.entity;

import barbearia.api.domain.dto.BarbeiroDto;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "barbeiros")
public class Barbeiro implements UserDetails {
	public Barbeiro(){

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "email")
	private String login;

	@Column(name= "telefone")
	private String telefone;

	@Column(name = "senha")
	private String senha;


	public Barbeiro(BarbeiroDto barbeiroDto) {
		this.nome = barbeiroDto.nome();
		this.login = barbeiroDto.login();
		this.telefone = barbeiroDto.telefone();
		this.senha = barbeiroDto.senha();
	}

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getSenha(){
		return senha;
	}

	public void setSenha(String senha){
		this.senha = senha;
	}

	public Long getId() {
		return id;
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
	public boolean isAccountNonExpired() {return true;}

	@Override
	public boolean isAccountNonLocked() {return true;}

	@Override
	public boolean isCredentialsNonExpired() {return true;}

	@Override
	public boolean isEnabled() {return true;}
}
