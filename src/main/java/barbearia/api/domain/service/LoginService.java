//package barbearia.api.domain.service;
//
//import barbearia.api.domain.dto.DadosLogin;
//import barbearia.api.domain.entity.Login;
//import barbearia.api.domain.repository.LoginRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//@Transactional
//public class LoginService {
//
//	@Autowired
//	private LoginRepository loginRepository;
//
//	public Login salvaDados(DadosLogin dadosLogin) {
//		return loginRepository.save(new Login(dadosLogin));
//	}
//}
