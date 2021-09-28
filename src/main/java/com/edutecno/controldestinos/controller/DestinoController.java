package com.edutecno.controldestinos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.edutecno.controldestinos.dto.DestinoDTO;
import com.edutecno.controldestinos.dto.PasajeroDTO;
import com.edutecno.controldestinos.model.Destino;
import com.edutecno.controldestinos.model.Pasajero;
import com.edutecno.controldestinos.service.DestinoService;
import com.edutecno.controldestinos.service.PasajeroService;

@Controller
@RequestMapping("/destinos")
public class DestinoController {

	@Autowired
	DestinoService destinoService;
	@Autowired
	PasajeroService pasajeroService;
	DestinoDTO destinoDto;
	PasajeroDTO pasajeroDto;

	@GetMapping("/crear")
	public ModelAndView crearDestino() {
		ModelAndView modelAndView = new ModelAndView("crear-destino");
		modelAndView.addObject("pasajeros", pasajeroService.findAll().getPasajeros());
		modelAndView.addObject("destino", new Destino());
		return modelAndView;
	}

	@PostMapping("/crear")
	public RedirectView crearDestinoPost(@ModelAttribute("destinos") Destino destino) {
		destinoService.save(destino);
		return new RedirectView("/destinos/destinos");
	}

	@GetMapping("/destinos")
	public ModelAndView pasajeros() {
		ModelAndView modelAndView = new ModelAndView("destinos");
		destinoDto = destinoService.findAll();
		modelAndView.addObject("destinos", destinoDto.getDestinos());
		return modelAndView;
	}

}
