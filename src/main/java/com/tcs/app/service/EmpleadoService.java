package com.tcs.app.service;

import java.util.List;

import com.tcs.app.model.Empleado;

public interface EmpleadoService {
	Empleado create(Empleado empleado);
	List<Empleado> list();
	void delete(Long idEmpleado);
	Empleado update(Empleado empleado);
	Empleado get(Long idEmpleado);
}
