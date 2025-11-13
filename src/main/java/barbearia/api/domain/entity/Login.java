//package barbearia.api.domain.entity;
//
//import barbearia.api.domain.dto.DadosLogin;
//import jakarta.persistence.*;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//
//@Entity
//@Table(name = "Login")
//public class Login implements UserDetails {
//	@Id
//	@Column(name = "ID")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	@Column(name = "EMAIL")
//	private String login;
//
//	@Column(name = "SENHA")
//	private String senha;
//
//	public Login(){
//
//	}
//
//	public Login(DadosLogin login){
//		this.login = login.login();
//		this.senha = login.senha();
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public String getLogin() {
//		return login;
//	}
//
//	public String getSenha() {
//		return senha;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
//	}
//
//	@Override
//	public String getPassword() {
//		return "{noop}" + senha;
//	}
//
//	@Override
//	public String getUsername() {
//		return login;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//}
