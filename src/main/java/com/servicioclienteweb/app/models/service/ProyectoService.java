package com.servicioclienteweb.app.models.service;

import java.util.List;


import com.servicioclienteweb.app.models.entity.Proyecto;

public interface ProyectoService {
	
	public List<Proyecto> findAll();
	public Proyecto findById(Long id);
	public Proyecto save(Proyecto proyecto);
	public Proyecto update(Proyecto proyecto);
	public void deleteById(Long id);

}
