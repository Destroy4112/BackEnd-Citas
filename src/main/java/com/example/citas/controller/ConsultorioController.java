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

import com.example.citas.model.Consultorio;
import com.example.citas.service.ConsultorioServiceImp;

@RestController
@RequestMapping("/api/consultorios")
public class ConsultorioController {

	@Autowired
	private ConsultorioServiceImp servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarConsultorios(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getConsultorios());
	}
	
	@GetMapping("/cantidad")
	public ResponseEntity<?> contador(){
		return ResponseEntity.ok(servicio.contador());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getConsultorioId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getConsultorioId(id));
	}
	
	@PostMapping
	public ResponseEntity<?> addConsultorio(@RequestBody Consultorio consultorio){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearConsultorio(consultorio));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarConsultorio(@PathVariable Long id){
		Optional<Consultorio> persona = servicio.getConsultorioId(id);
		if(!persona.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		servicio.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarConsultorio(@PathVariable Long id, @RequestBody Consultorio detalle){
		Optional<Consultorio> consultorio = servicio.getConsultorioId(id);
		if(!consultorio.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(detalle, consultorio.get());
		consultorio.get().setId(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearConsultorio(consultorio.get()));
	}
}
