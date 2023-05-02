package com.example.citas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.citas.model.EstadoDisponibilidadMedico;

@Repository
public interface EstadoDisponibilidadRepository extends JpaRepository<EstadoDisponibilidadMedico, Long> {

	@Query(value = "SELECT COUNT(*) FROM estado_disponibilidad_medico", nativeQuery = true)
	public int cantidadEstados();
}
