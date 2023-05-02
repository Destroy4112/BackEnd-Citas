package com.example.citas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.citas.model.Agendamiento;

@Repository
public interface AgendamientoRepository extends JpaRepository<Agendamiento, Long> {

	@Query(value = "SELECT COUNT(*) FROM agendamiento", nativeQuery = true)
	public int cantidadAgendamiento();
}
