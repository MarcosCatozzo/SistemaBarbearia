package barbearia.api.domain.service;

import barbearia.api.domain.dto.BarbeiroDto;
import barbearia.api.domain.dto.Email;
import barbearia.api.domain.dto.ListaDeBarbeirosDTO;
import barbearia.api.domain.entity.Barbeiro;
import barbearia.api.domain.repository.BarbeiroRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbeiroService {

	@Autowired
	private BarbeiroRepository barbeiroRepository;

	@Autowired
	private EmailService emailService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public void salvaCadastroBarbeiro(BarbeiroDto barbeiroDto){
		try {
			Barbeiro barbeiro = new Barbeiro(barbeiroDto);
			barbeiro.setSenha(passwordEncoder.encode(barbeiroDto.senha()));

			Email email = new Email(barbeiroDto.login(), "Cadastro Realizado!");

			emailService.envioDeEmail(email);

			barbeiroRepository.save(barbeiro);
		}catch (MessagingException e){
			e.getMessage();
		}
	}

	public List<ListaDeBarbeirosDTO> listagemBarbeiro(){
		return  barbeiroRepository.findAll().stream().map(ListaDeBarbeirosDTO::new).toList();
	}
}
