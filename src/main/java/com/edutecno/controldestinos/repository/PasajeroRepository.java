package com.edutecno.controldestinos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edutecno.controldestinos.model.Pasajero;

@Repository
public interface PasajeroRepository extends CrudRepository<Pasajero, Integer> {

}
