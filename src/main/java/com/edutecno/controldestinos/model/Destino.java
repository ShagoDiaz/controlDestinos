package com.edutecno.controldestinos.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "destino")
@SequenceGenerator(name = "SQ_Destino", initialValue = 1, sequenceName = "SQ_Destino", allocationSize = 1)
public class Destino {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_Destino")
	private Integer id;
	private String ciudad;
	private String pais;
	private String fecha;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Pasajero pasajero;
}
