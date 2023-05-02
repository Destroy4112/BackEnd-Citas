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

import com.example.citas.model.Rol;
import com.example.citas.service.RolServiceImp;

@RestController
@RequestMapping("/api/roles")
public class RolController {
	
	@Autowired
	private RolServiceImp servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarRoles(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getRoles());
	}
	
	@GetMapping("/cantidad")
	public ResponseEntity<?> contador(){
		return ResponseEntity.ok(servicio.contador());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarRolId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getRolesId(id));
	}
	
	@PostMapping
	public ResponseEntity<?> addRol(@RequestBody Rol rol){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.crearRol(rol));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarConsultorio(@PathVariable Long id, @RequestBody Rol detalle){
		Optional<Rol> rol = servicio.getRolesId(id);
		if(!rol.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(detalle, rol.get());
		rol.get().setId(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearRol(rol.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarEstado(@PathVariable Long id){
		Optional<Rol> rol = servicio.getRolesId(id);
		if(!rol.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		servicio.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
