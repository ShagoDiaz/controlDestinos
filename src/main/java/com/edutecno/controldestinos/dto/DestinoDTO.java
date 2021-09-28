package com.edutecno.controldestinos.dto;

import java.util.List;

import com.edutecno.controldestinos.model.Destino;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DestinoDTO extends GenericDTO {

	private List<Destino> destinos;

	public DestinoDTO(String mensaje, String codigo, List<Destino> destinos) {
		super(mensaje, codigo);
		this.destinos = destinos;
	}
}
