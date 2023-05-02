package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import com.example.citas.model.Rol;

public interface RolService {

	public List<Rol> getRoles();

	public Optional<Rol> getRolesId(Long id);

	public Rol crearRol(Rol rol);
	
	public int contador();
	
	public void deleteById(Long id);
}
