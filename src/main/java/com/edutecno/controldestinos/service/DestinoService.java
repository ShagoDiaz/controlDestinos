package com.edutecno.controldestinos.service;

import java.util.List;

import com.edutecno.controldestinos.dto.DestinoDTO;
import com.edutecno.controldestinos.model.Destino;

public interface DestinoService {

	public DestinoDTO save(Destino destino);

	public DestinoDTO findAll();

}
