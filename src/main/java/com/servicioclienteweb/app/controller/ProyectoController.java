package com.servicioclienteweb.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.servicioclienteweb.app.models.entity.Empleado;
import com.servicioclienteweb.app.models.entity.Proyecto;
import com.servicioclienteweb.app.models.service.ProyectoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ProyectoController {
	
	@Autowired
	private ProyectoService proyectoService;
	
	@GetMapping("/proyectos/listar")
	public String findAll(Model model) {
		model.addAttribute("proyectos", proyectoService.findAll());
		return "proyectos/listar";
	}
	
	@GetMapping("/proyectos/form")
	public String crear(Map<String, Object> model) {
		Proyecto proyecto = new  Proyecto();
		model.put("proyecto", proyecto);
		model.put("titulo", "Formulario nuevo proyecto");
		model.put("btn", "Crear nuevo proyecto");
		return "proyectos/form";
	}
	
	@GetMapping("/proyectos/form/{id}")
	public String  editar(@PathVariable("id") Long id, Map<String, Object> model) {
		Proyecto proyectoActual = null;
		if(id > 0) {
			proyectoActual = proyectoService.findById(id);
		}else {
			return "redirect:/proyectos/listar";
		}
		model.put("proyecto", proyectoActual);
		model.put("titulo", "Editar proyecto");
		model.put("btn", "Editar proyecto");
		return "proyectos/form";
	}
	
	@PostMapping("/proyectos/guardar")
	public String guardar(@ModelAttribute("proyecto") Proyecto proyecto) {
		proyectoService.save(proyecto);
        return "redirect:/proyectos/listar";
    }
	
	@GetMapping("/proyectos/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		proyectoService.deleteById(id);
		return "redirect:/proyectos/listar";
	}
	
	

}
