package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import com.example.citas.model.DisponibilidadMedico;

public interface DisponibilidadMedicoService {

	public List<DisponibilidadMedico> getDisponibilidadMedico();

	public Optional<DisponibilidadMedico> getDisponibilidadMedicoId(Long id);

	public DisponibilidadMedico addDisponibilidadMedico(DisponibilidadMedico disponibilidad);

	public int contador();
}
