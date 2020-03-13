package com.servicioclienteweb.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Proyecto  implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8337257575749660886L;
	private Long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaInicio;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaEstimadaFin;
	private Double presupuesto;
	private String recursos;


}
