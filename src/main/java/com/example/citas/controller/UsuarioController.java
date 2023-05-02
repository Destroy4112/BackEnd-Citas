package com.example.citas.controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.citas.model.Usuario;
import com.example.citas.service.UsuarioServiceImp;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImp servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarUsuarios(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getUsuarios());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarUsuariosId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getUsuariosId(id));
	}
	
	@PostMapping
	public ResponseEntity<?> agregarUsuario(@RequestBody Usuario user){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.addUser(user));
	}
	
	@GetMapping("/cantidad")
	public ResponseEntity<?> contador(){
		return ResponseEntity.ok(servicio.contador());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarUsuario(@PathVariable Long id, @RequestBody Usuario detalle){
		Optional<Usuario> user = servicio.getUsuariosId(id);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(detalle, user.get());
		user.get().setId(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.addUser(user.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable Long id){
		Optional<Usuario> user = servicio.getUsuariosId(id);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		servicio.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
