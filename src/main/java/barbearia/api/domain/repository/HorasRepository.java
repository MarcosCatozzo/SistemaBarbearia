package barbearia.api.domain.repository;

import barbearia.api.domain.entity.Horas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorasRepository extends JpaRepository<Horas, Long> {
}
