package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import com.example.citas.model.EstadoDisponibilidadMedico;

public interface EstadoDisponibilidadMedicoService {

	public List<EstadoDisponibilidadMedico> getEstadosDisponibilidadMedico();

	public Optional<EstadoDisponibilidadMedico> getEstadosDisponibilidadMedicoId(Long id);

	public EstadoDisponibilidadMedico crearEstadoDisponibilidadMedico(EstadoDisponibilidadMedico estado);
	
	public int contador();
	
	public void deleteById(Long id);
}
