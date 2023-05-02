package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.citas.model.Usuario;
import com.example.citas.repository.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepository repositorio;
	
	@Override
	public List<Usuario> getUsuarios() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Usuario> getUsuariosId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public Usuario addUser(Usuario user) {
		return repositorio.save(user);
	}

	@Override
	public List<Usuario> verificarUsuario(String usuario, String clave) {
		return repositorio.consultar(usuario, clave);
	}
	
	@Override
	public int contador() {
		return repositorio.cantidadUsuarios();
	}
	
	@Override
	public void deleteById(Long id) {
		repositorio.deleteById(id);
		
	}

}
