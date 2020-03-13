package com.servicioclienteweb.app.models.service;

import java.util.List;

import com.servicioclienteweb.app.models.entity.Empleado;
import com.servicioclienteweb.app.models.entity.Proyecto;

public interface EmpleadoService {
	
	
	public List<Empleado> findAll();
	public Empleado findById(Long id);
	public Empleado save(Empleado empleado);
	public Empleado update(Empleado empleado);
	public void deleteById(Long id);
	public List<Proyecto> findByFechaIngreso(String term);
	public Proyecto findProyectoById(Long id);

}
