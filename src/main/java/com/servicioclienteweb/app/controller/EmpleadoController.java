package com.servicioclienteweb.app.controller;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.servicioclienteweb.app.models.entity.Empleado;
import com.servicioclienteweb.app.models.entity.EmpleadoProyecto;
import com.servicioclienteweb.app.models.entity.Proyecto;
import com.servicioclienteweb.app.models.service.EmpleadoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("/empleados/listar")
	public String findAll(Model model) {
		model.addAttribute("empleados", empleadoService.findAll());
		return "empleados/listar";
	}
	
	@GetMapping("/empleados/detalle/{id}")
	public String  ver(@PathVariable("id") Long id, Map<String, Object> model) {
		Empleado empleadoActual = null;
		if(id > 0) {
			empleadoActual = empleadoService.findById(id);
		}else {
			return "redirect:/empleados/listar";
		}
		model.put("empleado", empleadoActual);
		model.put("titulo", "Detalle empleado: ".concat(empleadoActual.getNombre()+" "+empleadoActual.getApellido()));
		model.put("btn", "Agregar proyectos al empleado");
		return "empleados/detalle";
	}
	
	@GetMapping("/empleados/form")
	public String crear(Map<String, Object> model) {
		Empleado empleado = new Empleado();
		model.put("empleado", empleado);
		model.put("titulo", "Formulario nuevo empleado");
		model.put("btn", "Crear nuevo empleado");
		return "empleados/form";
	}
	
	@GetMapping("/empleados/form/{id}")
	public String  editar(@PathVariable("id") Long id, Map<String, Object> model) {
		Empleado empleadoActual = null;
		if(id > 0) {
			empleadoActual = empleadoService.findById(id);
		}else {
			return "redirect:/empleados/listar";
		}
		model.put("empleado", empleadoActual);
		model.put("titulo", "Editar empleado: ".concat(empleadoActual.getNombre()+" "+empleadoActual.getApellido()));
		model.put("btn", "Editar empleado");
		return "empleados/form";
	}
	
	@PostMapping("/empleados/guardar")
	public String guardar(@ModelAttribute("empleado") Empleado empleado) {
		empleadoService.save(empleado);
        return "redirect:/empleados/listar";
    }
	
	@GetMapping("/empleados/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		empleadoService.deleteById(id);
		return "redirect:/empleados/listar";
	}
	
	@GetMapping(value="/empleados/cargar-proyectos/{term}", produces = {"application/json"})
	public @ResponseBody List<Proyecto> cargarProyectos(@PathVariable String term){
		return empleadoService.findByFechaIngreso(term);
	}
	
	@PostMapping("/empleados/guardarEmpleadoProyecto")
	public String guardarEmpleadoProyecto(@ModelAttribute("empleado") Empleado empleado,
			@RequestParam(name="item_id[]", required=false) Long[] itemId,
			RedirectAttributes flash) {
		for (int i = 0; i < itemId.length; i++) {
			Proyecto proyecto = empleadoService.findProyectoById(itemId[i]);
			EmpleadoProyecto empleadoProyecto = new EmpleadoProyecto();
			empleadoProyecto.setProyecto(proyecto);
			empleado.addItem(empleadoProyecto);
		}
		empleadoService.save(empleado);
		return "redirect:/empleados/listar";
	}
}
