package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.citas.model.Paciente;
import com.example.citas.repository.PacienteRepository;

@Service
public class PacienteServiceImp implements PacienteService {

	@Autowired
	private PacienteRepository repositorio;
	
	@Override
	public List<Paciente> getPacientes() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Paciente> getPacienteId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public Paciente addPaciente(Paciente paciente) {
		return repositorio.save(paciente);
	}

	@Override
	public int contador() {
		return repositorio.cantidadPacientes();
	}

	
}
