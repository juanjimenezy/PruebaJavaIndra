package com.indra.prueba.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.indra.prueba.models.CategoriaProducto;



@Repository
public interface CategoriaProductoRepository extends CrudRepository<CategoriaProducto,Integer>{

}
