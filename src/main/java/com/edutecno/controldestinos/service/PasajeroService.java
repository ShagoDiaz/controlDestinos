package com.edutecno.controldestinos.service;

import com.edutecno.controldestinos.dto.PasajeroDTO;
import com.edutecno.controldestinos.model.Pasajero;

public interface PasajeroService {

	public PasajeroDTO save(Pasajero pasajero);

	public PasajeroDTO findAll();
}
