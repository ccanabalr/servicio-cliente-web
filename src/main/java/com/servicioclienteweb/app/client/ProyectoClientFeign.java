package com.servicioclienteweb.app.client;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.servicioclienteweb.app.models.entity.Proyecto;



@FeignClient(name = "servicio-proyecto", url = "localhost:8016/api")
public interface ProyectoClientFeign {
	
	@GetMapping("/proyectos")
	public List<Proyecto> findAll();
	
	@GetMapping("/proyectos/{id}")
	public Proyecto findById(@PathVariable Long id);
	
	@PostMapping("/proyectos")
	public Proyecto save(@RequestBody Proyecto proyecto);
	
	@PutMapping("/proyectos")
	public ResponseEntity<?> update(@RequestBody Proyecto proyecto);
	
	@DeleteMapping("/proyectos/{id}")
	public void deleteById(@PathVariable Long id);
}
