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

import com.example.citas.model.Horario;
import com.example.citas.service.HorarioServiceImp;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {
	
	@Autowired
	private HorarioServiceImp servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarHorarios(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getHorarios());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarHorarioId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getHorariosId(id));
	}
	
	@GetMapping("/cantidad")
	public ResponseEntity<?> contador(){
		return ResponseEntity.ok(servicio.contador());
	}
	
	@PostMapping
	public ResponseEntity<?> addEstado(@RequestBody Horario horario){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearHorario(horario));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarConsultorio(@PathVariable Long id, @RequestBody Horario detalle){
		Optional<Horario> horario = servicio.getHorariosId(id);
		if(!horario.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(detalle, horario.get());
		horario.get().setId(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearHorario(horario.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarEstado(@PathVariable Long id){
		Optional<Horario> horario = servicio.getHorariosId(id);
		if(!horario.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		servicio.eliminar(id);
		return ResponseEntity.ok().build();
	}

}
