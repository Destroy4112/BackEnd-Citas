package com.example.citas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.citas.model.Paciente;
import com.example.citas.service.PacienteServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

	@Autowired
	private PacienteServiceImp servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarPacientes(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getPacientes());
	}
	
	@GetMapping("/cantidad")
	public ResponseEntity<?> contador(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.contador());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarPacienteId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getPacienteId(id));
	}
	
	@PostMapping
	public ResponseEntity<?> crearPaciente(@RequestBody Paciente paciente){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.addPaciente(paciente));
	}
	
	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updatePartial(@RequestBody JsonPatch patch, @PathVariable Long id){
		try {
			Optional<Paciente> paciente = servicio.getPacienteId(id);
			if(!paciente.isPresent()) {
				return ResponseEntity.notFound().build();
			} 
			
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode patched = patch.apply(objectMapper.convertValue(paciente.get(), JsonNode.class));
		    Paciente pacientePatched = objectMapper.treeToValue(patched, Paciente.class);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(servicio.addPaciente(pacientePatched));
	    } catch (JsonPatchException | JsonProcessingException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    } 
	}
	
}
