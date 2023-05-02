package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.citas.model.Agendamiento;
import com.example.citas.repository.AgendamientoRepository;

@Service
public class AgendamientoServiceImp implements AgendamientoService {

	@Autowired
	private AgendamientoRepository repositorio;
	
	@Override
	public List<Agendamiento> getAgendas() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Agendamiento> getAgendaId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public Agendamiento addAgenda(Agendamiento agenda) {
		return repositorio.save(agenda);
	}
	
	@Override
	public int contador() {
		return repositorio.cantidadAgendamiento();
	}

}
