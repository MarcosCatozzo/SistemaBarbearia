package barbearia.api.domain.dto;

import barbearia.api.domain.entity.Servico;

public record ListaDeServicosDTO(String nomeDoServico, Double valorDoServico) {

	public ListaDeServicosDTO(Servico servico){
		this(servico.getNomeDoServico(), servico.getValorDoServico());
		}
}
