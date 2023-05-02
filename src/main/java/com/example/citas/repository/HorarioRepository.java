package com.example.citas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.citas.model.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {

	@Query(value = "SELECT COUNT(*) FROM horarios", nativeQuery = true)
	public int cantidadHorarios();
}
