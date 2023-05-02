package com.example.citas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.citas.model.EstadoAgendamiento;

@Repository
public interface EstadoAgendamientoRepository extends JpaRepository<EstadoAgendamiento, Long> {

	@Query(value = "SELECT COUNT(*) FROM estado_agendamiento", nativeQuery = true)
	public int cantidadEstados();
}
