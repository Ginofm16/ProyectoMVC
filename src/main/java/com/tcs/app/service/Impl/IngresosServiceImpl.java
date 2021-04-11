package com.tcs.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcs.app.dao.IngresosDao;
import com.tcs.app.model.Ingresos;
import com.tcs.app.service.IngresosService;

@Component
public class IngresosServiceImpl implements IngresosService{

	@Autowired
	private IngresosDao ingresosDao;

	@Override
	public Ingresos create(Ingresos ingresos) {
		// TODO Auto-generated method stub
		return ingresosDao.create(ingresos);
	}

	@Override
	public List<Ingresos> list() {
		// TODO Auto-generated method stub
		return ingresosDao.list();
	}

	@Override
	public void delete(Long idIngresos) {
		// TODO Auto-generated method stub
		ingresosDao.delete(idIngresos);
	}

	@Override
	public Ingresos update(Ingresos ingresos) {
		// TODO Auto-generated method stub
		return ingresosDao.update(ingresos);
	}

	@Override
	public Ingresos get(Long idIngresos) {
		// TODO Auto-generated method stub
		return ingresosDao.get(idIngresos);
	}
	
}
