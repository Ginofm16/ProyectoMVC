package com.tcs.app.service;

import java.util.List;

import com.tcs.app.model.Ingresos;

public interface IngresosService {

	Ingresos create(Ingresos ingresos);
	List<Ingresos> list();
	void delete(Long idIngresos);
	Ingresos update(Ingresos ingresos);
	Ingresos get(Long idIngresos);
	
}
