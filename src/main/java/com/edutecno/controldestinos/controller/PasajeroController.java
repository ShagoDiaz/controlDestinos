package com.edutecno.controldestinos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.edutecno.controldestinos.dto.PasajeroDTO;
import com.edutecno.controldestinos.model.Pasajero;
import com.edutecno.controldestinos.service.PasajeroService;

@Controller
@RequestMapping("/pasajeros")
public class PasajeroController {

	@Autowired
	PasajeroService pasajeroService;
	PasajeroDTO pasajeroDto;

	@GetMapping("/crear")
	public ModelAndView crearPasajero() {
		ModelAndView modelAndView = new ModelAndView("crear-pasajero");
		modelAndView.addObject("pasajero", new Pasajero());
		return modelAndView;
	}

	@PostMapping("/crear")
	public RedirectView crearPasajeroPost(@ModelAttribute("pasajero") Pasajero pasajero) {
		pasajeroService.save(pasajero);
		return new RedirectView("/pasajeros/pasajeros");
	}

	@GetMapping("/pasajeros")
	public ModelAndView pasajeros() {
		ModelAndView modelAndView = new ModelAndView("pasajeros");
		pasajeroDto = pasajeroService.findAll();
		modelAndView.addObject("pasajeros", pasajeroDto.getPasajeros());
		return modelAndView;
	}
}
