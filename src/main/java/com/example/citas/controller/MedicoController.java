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

import com.example.citas.model.Medico;
import com.example.citas.service.MedicoServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

	@Autowired
	private MedicoServiceImp servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarMedicos(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getMedicos());
	}
	
	@GetMapping("/cantidad")
	public ResponseEntity<?> contador(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.contador());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarMedicoId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getMedicosId(id));
	}
	
	@PostMapping
	public ResponseEntity<?> agregarMedico(@RequestBody Medico medico){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.addMedico(medico));
	}
	
	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updatePartial(@RequestBody JsonPatch patch, @PathVariable Long id){
		try {
			Optional<Medico> medico = servicio.getMedicosId(id);
			if(!medico.isPresent()) {
				return ResponseEntity.notFound().build();
			} 
			
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode patched = patch.apply(objectMapper.convertValue(medico.get(), JsonNode.class));
		    Medico medicoPatched = objectMapper.treeToValue(patched, Medico.class);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(servicio.addMedico(medicoPatched));
	    } catch (JsonPatchException | JsonProcessingException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    } 
	}
}
