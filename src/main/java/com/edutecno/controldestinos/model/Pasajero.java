package com.edutecno.controldestinos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pasajero")
@SequenceGenerator(name = "SQ_Pasajero", initialValue = 1, sequenceName = "SQ_Pasajero", allocationSize = 1)
public class Pasajero {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_Pasajero")
	private Integer id;
	private String rut;
	private String nombre;
	private String apellido;
	private int edad;
	private String ciudadNatal;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "pasajero_id", referencedColumnName = "id")
	private List<Destino> destinos;
}
