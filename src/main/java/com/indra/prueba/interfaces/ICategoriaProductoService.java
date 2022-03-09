package com.indra.prueba.interfaces;

import java.util.List;

import com.indra.prueba.models.CategoriaProducto;

public interface ICategoriaProductoService {
	
	public List<CategoriaProducto> findAll();
	
	public CategoriaProducto findById(Integer id);
	
	public CategoriaProducto save(CategoriaProducto categoriaProducto);
	
	public void deleteById(Integer id);

}
