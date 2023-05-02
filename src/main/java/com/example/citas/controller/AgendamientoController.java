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

import com.example.citas.model.Agendamiento;
import com.example.citas.service.AgendamientoServiceImp;

@RestController
@RequestMapping("/api/agendamiento")
public class AgendamientoController {

	@Autowired
	private AgendamientoServiceImp servicio;

	@GetMapping
	public ResponseEntity<?> consultarAgenda() {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getAgendas());
	}

	@GetMapping("/cantidad")
	public ResponseEntity<?> contador() {
		return ResponseEntity.ok(servicio.contador());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> consultarAgendaId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getAgendaId(id));
	}

	@PostMapping
	public ResponseEntity<?> agregarAgenda(@RequestBody Agendamiento agenda) {
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.addAgenda(agenda));
	}
}
