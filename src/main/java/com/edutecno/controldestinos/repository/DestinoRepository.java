package com.edutecno.controldestinos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edutecno.controldestinos.model.Destino;

@Repository
public interface DestinoRepository extends CrudRepository<Destino, Integer> {

}
