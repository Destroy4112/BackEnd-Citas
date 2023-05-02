package com.example.citas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.citas.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	@Query(value = "SELECT COUNT(*) FROM paciente m where m.estado=1", nativeQuery = true)
	public int cantidadPacientes(); 
}
