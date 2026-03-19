package barbearia.api.domain.repository;

import barbearia.api.domain.entity.Agendamento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

	List<Agendamento> findAll();

	Boolean existsByUsuario_IdAndDiaSemana_IdAndHorario_Id(
			Long barbeiro_id,
			Long dia_semana_id,
			Long horario_id
	);
}
