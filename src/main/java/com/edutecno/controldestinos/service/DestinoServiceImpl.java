package com.edutecno.controldestinos.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.controldestinos.ControlDestinosApplication;
import com.edutecno.controldestinos.dto.DestinoDTO;
import com.edutecno.controldestinos.model.Destino;
import com.edutecno.controldestinos.repository.DestinoRepository;

@Service
public class DestinoServiceImpl implements DestinoService {

	private static final Logger log = LoggerFactory.getLogger(ControlDestinosApplication.class);

	@Autowired
	private DestinoRepository repository;
	private DestinoDTO respuesta;

	@Override
	public DestinoDTO save(Destino destino) {
		respuesta = new DestinoDTO("Error intentando guardar en la BD", "100", new ArrayList<Destino>());
		try {
			respuesta.getDestinos().add(repository.save(destino));
			respuesta.setCodigo("000");
			respuesta.setMensaje("Destino registrado correctamente");
		} catch (Exception e) {
			log.error("DestinoService -> save : Error " + e);
		}
		return respuesta;

	}

	@Override
	public DestinoDTO findAll() {
		respuesta = new DestinoDTO("Error intentando leer desde la BD", "100", new ArrayList<Destino>());
		try {
			respuesta.setDestinos((List<Destino>) repository.findAll());
			respuesta.setCodigo("000");
			respuesta.setMensaje("Destinos cargados correctamente");
		} catch (Exception e) {
			log.error("DestinoService -> findAll : Error " + e);
		}

		return respuesta;
	}

}
