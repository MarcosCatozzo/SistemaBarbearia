package barbearia.api.domain.repository;

import barbearia.api.domain.entity.Agendamento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
