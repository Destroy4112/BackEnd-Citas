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

import com.example.citas.model.EstadoDisponibilidadMedico;
import com.example.citas.service.EstadoDisponibilidadMedicoServiceImp;

@RestController
@RequestMapping("/api/estados_disponibilidad_medico")
public class EstadoDisponibilidadMedicoController {

	@Autowired
	private EstadoDisponibilidadMedicoServiceImp servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarEstado(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getEstadosDisponibilidadMedico());
	}
	
	@GetMapping("/cantidad")
	public ResponseEntity<?> contador(){
		return ResponseEntity.ok(servicio.contador());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarEstadoId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getEstadosDisponibilidadMedicoId(id));
	}
	
	@PostMapping
	public ResponseEntity<?> addEstado(@RequestBody EstadoDisponibilidadMedico estado){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearEstadoDisponibilidadMedico(estado));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarConsultorio(@PathVariable Long id, @RequestBody EstadoDisponibilidadMedico detalle){
		Optional<EstadoDisponibilidadMedico> estado = servicio.getEstadosDisponibilidadMedicoId(id);
		if(!estado.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(detalle, estado.get());
		estado.get().setId(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearEstadoDisponibilidadMedico(estado.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarEstado(@PathVariable Long id){
		Optional<EstadoDisponibilidadMedico> estado = servicio.getEstadosDisponibilidadMedicoId(id);
		if(!estado.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		servicio.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
