package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import com.example.citas.model.EstadoAgendamiento;

public interface EstadoAgendamientoService {

	public List<EstadoAgendamiento> getEstadosAgendamiento();
	
	public Optional<EstadoAgendamiento> getEstadoAgendamientoId(Long id);

	public EstadoAgendamiento crearEstadosAgendamiento(EstadoAgendamiento estado);

	public int contador();
	
	public void deleteById(Long id);
}
