package com.edutecno.controldestinos.dto;

import java.util.List;

import com.edutecno.controldestinos.model.Pasajero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PasajeroDTO extends GenericDTO {

	private List<Pasajero> pasajeros;

	public PasajeroDTO(List<Pasajero> pasajeros, String mensaje, String codigo) {
		super(mensaje, codigo);
		this.pasajeros = pasajeros;
	}
}
