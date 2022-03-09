package com.indra.prueba.interfaces;

import java.util.List;

import com.indra.prueba.models.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findById(Integer id);
	
	public Usuario save(Usuario usuario);
	
	public void deleteById(Integer id);
	
	public Usuario usuarioByLogin(String username);

}
