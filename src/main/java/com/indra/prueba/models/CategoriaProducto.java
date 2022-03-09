package com.indra.prueba.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA_PRODUCTO")
public class CategoriaProducto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idCategoria_Sequence")
	@SequenceGenerator(name = "idCategoria_Sequence", sequenceName = "idCategoria_Sequence", allocationSize = 1, initialValue = 5)
	@Column(name= "ID_CATEGORIA_PRODUCTO", nullable=false)
	private Integer idCategoriaProducto;
	
	@Column(name="NOMBRE", nullable = false)
	private String nombre;

	public Integer getIdCategoriaProducto() {
		return idCategoriaProducto;
	}

	public void setIdCategoriaProducto(Integer idCategoriaProducto) {
		this.idCategoriaProducto = idCategoriaProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
