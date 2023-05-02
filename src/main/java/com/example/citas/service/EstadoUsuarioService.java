package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import com.example.citas.model.EstadoUsuario;

public interface EstadoUsuarioService {

	public List<EstadoUsuario> getEstadosUsuario();

	public Optional<EstadoUsuario> getEstadosUsuarioId(Long id);

	public EstadoUsuario crearEstadoUsuario(EstadoUsuario estado);
	
	public int contador();
	
	public void deleteById(Long id);
}
