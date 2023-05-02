package com.example.citas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.citas.model.DisponibilidadMedico;
import com.example.citas.service.DisponibilidadMedicoServiceImp;

@RestController
@RequestMapping("/api/disponibilidad_medico")
public class DisponibilidadController {

	@Autowired
	private DisponibilidadMedicoServiceImp servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarDisponibilidades(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getDisponibilidadMedico());
	}
	
	@GetMapping("/cantidad")
	public ResponseEntity<?> contador(){
		return ResponseEntity.ok(servicio.contador());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarDisponibilidadId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getDisponibilidadMedicoId(id));
	}
	
	@PostMapping
	public ResponseEntity<?> agregarDisponibilidad(@RequestBody DisponibilidadMedico disponibilidad){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.addDisponibilidadMedico(disponibilidad));
	}
}
