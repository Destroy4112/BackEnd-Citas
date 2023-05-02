package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import com.example.citas.model.Paciente;

public interface PacienteService {

	public List<Paciente> getPacientes();

	public Optional<Paciente> getPacienteId(Long id);

	public Paciente addPaciente(Paciente paciente);
	
	public int contador();
}
