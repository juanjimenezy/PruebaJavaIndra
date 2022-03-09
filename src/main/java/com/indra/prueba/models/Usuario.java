package com.indra.prueba.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@Column(name = "IDUSUARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idUsuario_Sequence")
	@SequenceGenerator(name = "idUsuario_Sequence", sequenceName = "idUsuario_Sequence", allocationSize = 1, initialValue = 3)
	private Integer idUsuario;

	@Column(name = "USERNAME", nullable = false, unique = true)
	private String username;

	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	@Column(name = "APELLIDO", nullable = false)
	private String apellido;

	@Column(name = "IDENTIFICACION", nullable = false)
	private String identificacion;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "FECHA_CREACION", nullable = false)
	private Date fechaCreacion;

	@PrePersist
	public void prePersist() {
		this.fechaCreacion = new Date();
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
