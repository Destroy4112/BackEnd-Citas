package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.citas.model.EstadoUsuario;
import com.example.citas.repository.EstadoUsuarioRepository;

@Service
public class EstadoUsuarioServiceImp implements EstadoUsuarioService {

	@Autowired
	private EstadoUsuarioRepository repositorio;
	
	@Override
	public List<EstadoUsuario> getEstadosUsuario() {
		return repositorio.findAll();
	}

	@Override
	public Optional<EstadoUsuario> getEstadosUsuarioId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public EstadoUsuario crearEstadoUsuario(EstadoUsuario estado) {
		return repositorio.save(estado);
	}
	
	@Override
	public int contador() {
		return repositorio.cantidadEstados();
	}
	
	@Override
	public void deleteById(Long id) {
		repositorio.deleteById(id);
		
	}

}
