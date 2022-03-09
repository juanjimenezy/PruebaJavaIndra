package com.indra.prueba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.prueba.interfaces.IProductoService;
import com.indra.prueba.models.Producto;
import com.indra.prueba.repositories.ProductoRepository;

@Service
public class ProductoService implements IProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Producto> findAll() {
		return (List<Producto>) productoRepository.findAll();
	}

	@Override
	public Producto findById(Integer id) {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public void deleteById(Integer id) {
		productoRepository.deleteById(id);
	}

}
