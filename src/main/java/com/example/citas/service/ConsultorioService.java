package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import com.example.citas.model.Consultorio;

public interface ConsultorioService {
	
	public List<Consultorio> getConsultorios();
	
	public Optional<Consultorio> getConsultorioId(Long id);
	
	public Consultorio crearConsultorio(Consultorio consultorio);
	
	public void deleteById(Long id);
	
	public int contador();

}
