package com.servicioclienteweb.app.client;


import java.util.Date;
import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.servicioclienteweb.app.models.entity.Empleado;
import com.servicioclienteweb.app.models.entity.Proyecto;



@FeignClient(name = "servicio-empleado", url = "localhost:8016/api")
public interface EmpleadoClientFeign {
	

	@GetMapping("/empleados")
	public List<Empleado> findAll();
	
	@GetMapping("/empleados/{id}")
	public Empleado findById(@PathVariable Long id);
	
	@PostMapping("/empleados")
	public Empleado save(@RequestBody Empleado empleado);
	
	@PutMapping("/empleados")
	public Empleado update(@RequestBody Empleado empleado);
	
	@DeleteMapping("/empleados/{id}")
	public void deleteById(@PathVariable Long id);
	
	@GetMapping("empleados/cargar-proyectos/{term}")
	public  List<Proyecto> cargarProyectos(@PathVariable String term);
	
	@GetMapping("empleados/buscar-proyecto/{id}")
	public Proyecto findProyectoById(@PathVariable Long id);

}
