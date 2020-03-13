package com.servicioclienteweb.app.models.entity;


import java.io.Serializable;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoProyecto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -284337105068279532L;
	private Long id;
	private Empleado empleado;
	private Proyecto proyecto;
	
	

}