package barbearia.api.domain.repository;

import barbearia.api.domain.dto.AgendamentoDTO;
import barbearia.api.domain.entity.Agendamento;
import barbearia.api.domain.entity.Barbeiro;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

	List<Agendamento> findAll();

	List<Agendamento> findAllByBarbeiroId(Long id);

	Boolean existsByBarbeiro_IdAndDiaDaSemana_IdAndHorario_Id(
			Long barbeiro_id,
			Long dia_semana_id,
			Long horario_id
	);
}
