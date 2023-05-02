package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.citas.model.EstadoDisponibilidadMedico;
import com.example.citas.repository.EstadoDisponibilidadRepository;

@Service
public class EstadoDisponibilidadMedicoServiceImp implements EstadoDisponibilidadMedicoService {

	@Autowired
	private EstadoDisponibilidadRepository repositorio;
	
	@Override
	public List<EstadoDisponibilidadMedico> getEstadosDisponibilidadMedico() {
		return repositorio.findAll();
	}

	@Override
	public Optional<EstadoDisponibilidadMedico> getEstadosDisponibilidadMedicoId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public EstadoDisponibilidadMedico crearEstadoDisponibilidadMedico(EstadoDisponibilidadMedico estado) {
		return repositorio.save(estado);
	}
	
	@Override
	public int contador() {
		return repositorio.cantidadEstados();
	}

	@Override
	public void deleteById(Long id) {
		repositorio.deleteById(id);
		
	}

}
