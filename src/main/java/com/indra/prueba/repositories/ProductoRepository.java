package com.indra.prueba.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.indra.prueba.models.Producto;



@Repository
public interface ProductoRepository extends CrudRepository<Producto,Integer>{

}
