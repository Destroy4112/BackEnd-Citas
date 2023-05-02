package com.example.citas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.citas.model.Consultorio;

@Repository
public interface ConsultorioRepository extends JpaRepository<Consultorio, Long> {

	@Query(value = "SELECT COUNT(*) FROM consultorio", nativeQuery = true)
	public int cantidadConsultorios();

}
