package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.citas.model.Rol;
import com.example.citas.repository.RolRepository;

@Service
public class RolServiceImp implements RolService {

	@Autowired
	private RolRepository repositorio;
	
	@Override
	public List<Rol> getRoles() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Rol> getRolesId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public Rol crearRol(Rol rol) {
		return repositorio.save(rol);
	}

	@Override
	public int contador() {
		return repositorio.cantidadRoles();
	}
	
	@Override
	public void deleteById(Long id) {
		repositorio.deleteById(id);
		
	}
}
