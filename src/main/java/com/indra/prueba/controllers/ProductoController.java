package com.indra.prueba.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.indra.prueba.models.Producto;
import com.indra.prueba.services.ProductoService;

@CrossOrigin(origins = {"*"})
@RequestMapping("/Api")
@RestController
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/productos")
	public ResponseEntity<?> getProductos(){
		Map<String, Object> response = new HashMap<>();
		List<Producto> productos = null;
		
		try {
			productos = productoService.findAll();
			
			if (productos.size() == 0) {
				response.put("mensaje", "No existen Productos");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
	}
	
	@GetMapping("/productosById")
	public ResponseEntity<?> prodById(@RequestParam Integer idProducto) {
		Map<String, Object> response = new HashMap<>();
		Producto producto = productoService.findById(idProducto);

		if (producto == null) {
			response.put("mensaje", "No existe producto");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@PutMapping("/productos")
	public ResponseEntity<?> created(@RequestBody Producto producto) {
		Map<String, Object> response = new HashMap<>();
		Producto productoNew = null;
		try {
			productoNew = productoService.save(producto);
			if (productoNew == null) {
				response.put("mensaje", "Error al grabar producto");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Producto>(productoNew, HttpStatus.OK);
	}
	
	@PostMapping("/productos")
	public ResponseEntity<?> update(@RequestBody Producto producto){
		Map<String, Object> response = new HashMap<>();
		Producto productoUp = null;
		
		try {
			productoUp = productoService.save(producto);
			if (productoUp == null) {
				response.put("mensaje", "Error al grabar producto");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Producto>(productoUp, HttpStatus.OK);
	}
	
	@DeleteMapping("/productos")
	public ResponseEntity<?> deleteById(@RequestParam Integer id){
		Map<String, Object> response = new HashMap<>();
		try {
			productoService.deleteById(id);
		} catch (Exception e) {
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	

}
