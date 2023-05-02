package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.citas.model.EstadoAgendamiento;
import com.example.citas.repository.EstadoAgendamientoRepository;

@Service
public class EstadoAgendamientoServiceImp implements EstadoAgendamientoService {

	@Autowired
	private EstadoAgendamientoRepository repositorio;

	@Override
	public List<EstadoAgendamiento> getEstadosAgendamiento() {
		return repositorio.findAll();
	}

	@Override
	public EstadoAgendamiento crearEstadosAgendamiento(EstadoAgendamiento estado) {
		return repositorio.save(estado);
	}

	@Override
	public Optional<EstadoAgendamiento> getEstadoAgendamientoId(Long id) {
		return repositorio.findById(id);
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
