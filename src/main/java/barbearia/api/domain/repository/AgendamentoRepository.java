package barbearia.api.domain.repository;

import barbearia.api.domain.dto.AgendamentoDTO;
import barbearia.api.domain.entity.Agendamento;
import barbearia.api.domain.entity.Barbeiro;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

	Boolean existsByBarbeiro_IdAndDiaDaSemana_IdAndHorario_Id(
			Long barbeiro_id,
			Long dia_semana_id,
			Long horario_id
	);
}
