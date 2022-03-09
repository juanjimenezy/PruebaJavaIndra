package com.indra.prueba.interfaces;

import java.util.List;

import com.indra.prueba.models.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	
	public Producto findById(Integer id);
	
	public Producto save(Producto producto);
	
	public void deleteById(Integer id);

}
