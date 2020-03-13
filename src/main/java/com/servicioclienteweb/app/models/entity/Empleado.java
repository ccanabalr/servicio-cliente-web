package com.servicioclienteweb.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


public class Empleado implements Serializable {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4413453381062540993L;
	private Long id;
	private String nombre;
	private String apellido;
	private Double salario;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaIngreso;
	private List<EmpleadoProyecto> empleadoProyectos;
	
	
	public Empleado() {
		this.empleadoProyectos = new ArrayList<EmpleadoProyecto>();
	}
	
	public void addItem(EmpleadoProyecto item) {
		this.empleadoProyectos.add(item);
	}
	



}
