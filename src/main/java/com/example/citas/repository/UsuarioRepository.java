package com.example.citas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.citas.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query(value="SELECT * FROM usuarios u WHERE u.usuario = ?1 and u.password = ?2", nativeQuery = true)
	public List<Usuario> consultar(String usuario, String clave);
	
	@Query(value = "SELECT COUNT(*) FROM usuarios", nativeQuery = true)
	public int cantidadUsuarios();
}
