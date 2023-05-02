package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import com.example.citas.model.Agendamiento;

public interface AgendamientoService {
	
	public List<Agendamiento> getAgendas();
	
	public Optional<Agendamiento> getAgendaId(Long id);
	
	public Agendamiento addAgenda(Agendamiento agenda);
	
	public int contador();

}
