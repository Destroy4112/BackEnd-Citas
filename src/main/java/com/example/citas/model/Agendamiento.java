package com.example.citas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "agendamiento")
public class Agendamiento implements Serializable{

	private static final long serialVersionUID = -6034717460229227616L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="disponibilidad")
	private DisponibilidadMedico disponibilidad;
	
	@ManyToOne
	@JoinColumn(name="estado")
	private EstadoAgendamiento estado;
	
	public Agendamiento() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DisponibilidadMedico getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(DisponibilidadMedico disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public EstadoAgendamiento getEstado() {
		return estado;
	}

	public void setEstado(EstadoAgendamiento estado) {
		this.estado = estado;
	}
	
}
