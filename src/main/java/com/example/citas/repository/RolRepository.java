package com.example.citas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.citas.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

	@Query(value = "SELECT COUNT(*) FROM roles", nativeQuery = true)
	public int cantidadRoles();
}
