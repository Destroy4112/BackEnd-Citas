package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import com.example.citas.model.Horario;

public interface HorarioService {

	public List<Horario> getHorarios();

	public Optional<Horario> getHorariosId(Long id);

	public Horario crearHorario(Horario horario);
	
	public int contador();
	
	public void eliminar(Long id);
}
