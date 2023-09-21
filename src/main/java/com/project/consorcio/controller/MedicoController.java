package com.project.consorcio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.consorcio.services.DistritoServices;
import com.project.consorcio.services.EspecialidadServices;
import com.project.consorcio.services.MedicoServices;
import com.project.consorcio.services.SedeServices;

@Controller
@RequestMapping("/medico")
public class MedicoController {
	@Autowired
	private MedicoServices servicioMedico;
	
	@Autowired
	private DistritoServices servicioDistrito;
	
	@Autowired
	private EspecialidadServices servicioEspecialidad;
	
	@Autowired
	private SedeServices servicioSede;
	
	
	@RequestMapping("/listado")
	public String index(Model model) { 
		model.addAttribute("medicos", servicioMedico.listarTodos());
		model.addAttribute("especialidad", servicioEspecialidad.listarTodos());
		model.addAttribute("distrito", servicioDistrito.listarTodos());
		model.addAttribute("sede", servicioSede.listarTodos());
		
		return "medico";
	}
}
