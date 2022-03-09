package com.indra.prueba.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.indra.prueba.models.Usuario;
import com.indra.prueba.services.UsuarioService;

@CrossOrigin(origins = {"*"})
@RequestMapping("/Api")
@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public ResponseEntity<?> getUsuarios(){
		Map<String, Object> response = new HashMap<>();
		List<Usuario> usuarios = null;
		
		try {
			usuarios = usuarioService.findAll();
			
			if (usuarios.size() == 0) {
				response.put("mensaje", "No existen Usuarios");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@PutMapping("/usuarios")
	public ResponseEntity<?> created(@RequestBody Usuario usuario) {
		Map<String, Object> response = new HashMap<>();
		Usuario usuarioNew = null;
		try {
			usuarioNew = usuarioService.save(usuario);
			if (usuarioNew == null) {
				response.put("mensaje", "Error al grabar usuario");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Usuario>(usuarioNew, HttpStatus.OK);
	}
	
	@GetMapping("/usuariosByLogin")
	public ResponseEntity<?> usuariById(@RequestParam String username) {
		Map<String, Object> response = new HashMap<>();
		Usuario usuario = usuarioService.usuarioByLogin(username);

		if (usuario == null) {
			response.put("mensaje", "Usuario incorrectO");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

}
