package com.example.citas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.citas.model.EstadoUsuario;

@Repository
public interface EstadoUsuarioRepository extends JpaRepository<EstadoUsuario, Long> {

	@Query(value = "SELECT COUNT(*) FROM estado_usuario", nativeQuery = true)
	public int cantidadEstados();
}
