package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.citas.model.Horario;
import com.example.citas.repository.HorarioRepository;

@Service
public class HorarioServiceImp implements HorarioService {

	@Autowired
	private HorarioRepository repositorio;
	
	@Override
	public List<Horario> getHorarios() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Horario> getHorariosId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public Horario crearHorario(Horario horario) {
		return repositorio.save(horario);
	}
	
	@Override
	public int contador() {
		return repositorio.cantidadHorarios();
	}

	@Override
	public void eliminar(Long id) {
		repositorio.deleteById(id);
	}
}
