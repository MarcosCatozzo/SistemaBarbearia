package barbearia.api.domain.repository;

import barbearia.api.domain.entity.Horas;
import barbearia.api.domain.service.HorarioService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface HorasRepository extends JpaRepository<Horas, Long> {
	List<Horas> findAll();

}

