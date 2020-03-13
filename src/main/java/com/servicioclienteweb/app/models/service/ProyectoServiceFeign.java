package com.servicioclienteweb.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicioclienteweb.app.client.ProyectoClientFeign;
import com.servicioclienteweb.app.models.entity.Proyecto;
@Service
public class ProyectoServiceFeign implements ProyectoService  {
	
	@Autowired
    private ProyectoClientFeign proyectoClientFeign;

	@Override
	public List<Proyecto> findAll() {
		// TODO Auto-generated method stub
		return proyectoClientFeign.findAll();
	}

	@Override
	public Proyecto findById(Long id) {
		// TODO Auto-generated method stub
		return proyectoClientFeign.findById(id);
	}

	@Override
	public Proyecto save(Proyecto proyecto) {
		// TODO Auto-generated method stub
		return proyectoClientFeign.save(proyecto);
	}

	@Override
	public Proyecto update(Proyecto proyecto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		proyectoClientFeign.deleteById(id);
	}

}
