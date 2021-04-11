package com.tcs.app.dao;

import java.util.List;

import com.tcs.app.model.Empleado;

public interface EmpleadoDao {

	Empleado create(Empleado empleado);
	List<Empleado> list();
	void delete(Long idEmpleado);
	Empleado update(Empleado empleado);
	Empleado get(Long idEmpleado);
	
	
}
