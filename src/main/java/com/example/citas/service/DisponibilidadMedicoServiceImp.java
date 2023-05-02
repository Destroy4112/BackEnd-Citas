package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.citas.model.DisponibilidadMedico;
import com.example.citas.repository.DisponibilidadMedicoRepository;

@Service
public class DisponibilidadMedicoServiceImp implements DisponibilidadMedicoService {

	@Autowired
	private DisponibilidadMedicoRepository repositorio; 
	
	@Override
	public List<DisponibilidadMedico> getDisponibilidadMedico() {
		return repositorio.findAll();
	}

	@Override
	public Optional<DisponibilidadMedico> getDisponibilidadMedicoId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public DisponibilidadMedico addDisponibilidadMedico(DisponibilidadMedico disponibilidad) {
		return repositorio.save(disponibilidad);
	}
	
	@Override
	public int contador() {
		return repositorio.cantidadDisponibilidad();
	}

}
