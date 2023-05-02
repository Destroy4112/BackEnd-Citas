package com.example.citas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="paciente")
public class Paciente implements Serializable{

	private static final long serialVersionUID = -4850320462794075608L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombres", nullable = false)
	private String nombres;
	
	@Column(name="apellidos", nullable = false)
	private String apellidos;
	
	@Column(name="documento", nullable = false, unique = true)
	private String documento;
	
	@Column(name="eps", nullable = false)
	private String eps;
	
	@Column(name="telefono", length = 50, nullable = false)
	private String telefono;
	
	@JoinColumn(name="usuario", unique = true)
	@OneToOne
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="estado")
	private EstadoUsuario estado;
	
	public Paciente() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public EstadoUsuario getEstado() {
		return estado;
	}

	public void setEstado(EstadoUsuario estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
