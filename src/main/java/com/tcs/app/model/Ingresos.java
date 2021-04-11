package com.tcs.app.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Ingresos {
	
	private long id;
	
	private Empleado empleado;
	
	private BigDecimal monto;

}
