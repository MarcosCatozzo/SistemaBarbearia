package barbearia.api.domain.repository;

import barbearia.api.domain.entity.DiaSemana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaSemanaRepository extends JpaRepository<DiaSemana, Long> {

	DiaSemana findByDia(String dia);

	List<DiaSemana> findAll();
}
