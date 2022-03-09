package com.indra.prueba.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.indra.prueba.enums.Estado;

@Entity
@Table(name="Producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idProducto_Sequence")
	@SequenceGenerator(name = "idProducto_Sequence", sequenceName = "idProducto_sequence", allocationSize = 1, initialValue = 5)
	@Column(name= "ID_PRODUCTO", nullable=false)
	private Integer idProducto;
	
	@Column(name= "NOMBRE", nullable=false, unique=true)
	private String nombre;
	
	@ManyToOne()
	@JoinColumn(name= "ID_CATEGORIA_PRODUCTO", nullable = false)
	private CategoriaProducto idCategoriaPrudcto;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ESTADO", nullable=false)
	private Estado estado;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CategoriaProducto getIdCategoriaPrudcto() {
		return idCategoriaPrudcto;
	}

	public void setIdCategoriaPrudcto(CategoriaProducto idCategoriaPrudcto) {
		this.idCategoriaPrudcto = idCategoriaPrudcto;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	

}
