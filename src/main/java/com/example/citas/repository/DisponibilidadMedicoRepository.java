package com.example.citas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.citas.model.DisponibilidadMedico;

@Repository
public interface DisponibilidadMedicoRepository extends JpaRepository<DisponibilidadMedico, Long> {

	@Query(value = "SELECT COUNT(*) FROM disponibilidad_medico", nativeQuery = true)
	public int cantidadDisponibilidad();
}
