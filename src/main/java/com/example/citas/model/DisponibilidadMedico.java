package com.example.citas.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "disponibilidad_medico")
public class DisponibilidadMedico implements Serializable {

	private static final long serialVersionUID = 4672678742467636282L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "medico")
	private Medico medico;

	@ManyToOne
	@JoinColumn(name = "horario")
	private Horario horario;

	@ManyToOne
	@JoinColumn(name = "estado")
	private EstadoDisponibilidadMedico estado;

	private Date fecha;
	
	public DisponibilidadMedico() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public EstadoDisponibilidadMedico getEstado() {
		return estado;
	}

	public void setEstado(EstadoDisponibilidadMedico estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	
}
