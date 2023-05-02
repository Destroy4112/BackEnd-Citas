package com.example.citas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.citas.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

	@Query(value = "SELECT * FROM medico m where m.estado=1", nativeQuery = true)
	public List<Medico> consultarMedicosActivos();
	
	@Query(value = "SELECT COUNT(*) FROM medico m where m.estado=1", nativeQuery = true)
	public int cantidadMedicos();
}
