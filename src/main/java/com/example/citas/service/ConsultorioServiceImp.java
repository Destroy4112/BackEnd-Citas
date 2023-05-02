package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.citas.model.Consultorio;
import com.example.citas.repository.ConsultorioRepository;

@Service
public class ConsultorioServiceImp implements ConsultorioService {

	@Autowired
	private ConsultorioRepository repositorio;
	
	@Override
	public List<Consultorio> getConsultorios() {
		return repositorio.findAll();
	}

	@Override
	public Consultorio crearConsultorio(Consultorio consultorio) {
		return repositorio.save(consultorio);
	}

	@Override
	public Optional<Consultorio> getConsultorioId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		repositorio.deleteById(id);
	}

	@Override
	public int contador() {
		return repositorio.cantidadConsultorios();
	}

}
