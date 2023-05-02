package com.example.citas.service;

import java.util.List;
import java.util.Optional;

import com.example.citas.model.Usuario;

public interface UsuarioService {

	public List<Usuario> getUsuarios();
	public Optional<Usuario> getUsuariosId(Long id);
	public Usuario addUser(Usuario user);
	public List<Usuario> verificarUsuario(String usuario, String clave);
	public int contador();
	public void deleteById(Long id);
}
