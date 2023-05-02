package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import com.example.citas.model.Medico;

public interface MedicoService {

	public Medico addMedico(Medico medico);

	public List<Medico> getMedicos();

	public Optional<Medico> getMedicosId(Long id);

	public int contador();

	public Medico updateMedico(Medico medico);

}
