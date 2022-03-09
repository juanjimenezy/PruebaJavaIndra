package com.indra.prueba.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indra.prueba.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Integer>{
	
	@Query("SELECT u FROM Usuario u WHERE u.username = :username")
	Usuario usuarioByLogin(@Param("username") String username);

}
