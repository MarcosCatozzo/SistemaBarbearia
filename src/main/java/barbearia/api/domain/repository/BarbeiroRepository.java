package barbearia.api.domain.repository;

import barbearia.api.domain.entity.Barbeiro;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BarbeiroRepository extends JpaRepository<Barbeiro,Long> {
}
