package com.servicioclienteweb.app.models.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.servicioclienteweb.app.client.EmpleadoClientFeign;
import com.servicioclienteweb.app.models.entity.Empleado;
import com.servicioclienteweb.app.models.entity.Proyecto;

@Service("ServiceFeign")
@Primary
public class EmpleadoServiceFeign implements EmpleadoService {
	
	@Autowired
	private EmpleadoClientFeign empleadoClienteFeign;

	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return empleadoClienteFeign.findAll();
	}

	@Override
	public Empleado findById(Long id) {
		// TODO Auto-generated method stub
		return empleadoClienteFeign.findById(id);
	}

	@Override
	public Empleado save(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoClienteFeign.save(empleado);
	}

	@Override
	public Empleado update(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoClienteFeign.update(empleado);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		empleadoClienteFeign.deleteById(id);
	}

	@Override
	public List<Proyecto> findByFechaIngreso(String term) {
		// TODO Auto-generated method stub
		return empleadoClienteFeign.cargarProyectos(term);
	}

	@Override
	public Proyecto findProyectoById(Long id) {
		return empleadoClienteFeign.findProyectoById(id);
	}

}
