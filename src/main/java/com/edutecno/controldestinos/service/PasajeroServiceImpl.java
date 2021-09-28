package com.edutecno.controldestinos.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.controldestinos.ControlDestinosApplication;
import com.edutecno.controldestinos.dto.DestinoDTO;
import com.edutecno.controldestinos.dto.PasajeroDTO;
import com.edutecno.controldestinos.model.Destino;
import com.edutecno.controldestinos.model.Pasajero;
import com.edutecno.controldestinos.repository.PasajeroRepository;

@Service
public class PasajeroServiceImpl implements PasajeroService {
	private static final Logger log = LoggerFactory.getLogger(ControlDestinosApplication.class);

	@Autowired
	private PasajeroRepository repository;
	private PasajeroDTO respuesta;

	@Override
	public PasajeroDTO save(Pasajero pasajero) {
		respuesta = new PasajeroDTO(new ArrayList<Pasajero>(), "100", "Error intentando guardar en la BD");
		try {
			respuesta.getPasajeros().add(repository.save(pasajero));
			respuesta.setCodigo("000");
			respuesta.setMensaje("Pasajero registrado correctamente");
		} catch (Exception e) {
			log.error("PasajeroService -> save : Error " + e);
		}
		return respuesta;

	}

	@Override
	public PasajeroDTO findAll() {
		respuesta = new PasajeroDTO(new ArrayList<Pasajero>(), "100", "Error intentando leer desde la BD");
		try {
			respuesta.setPasajeros((List<Pasajero>) repository.findAll());
			respuesta.setCodigo("000");
			respuesta.setMensaje("Psajeros cargados correctamente");
		} catch (Exception e) {
			log.error("PasajeroService -> findAll : Error " + e);
		}

		return respuesta;
	}

}
