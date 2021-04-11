package com.tcs.app.dao.impl;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.tcs.app.dao.IngresosDao;
import com.tcs.app.dao.rowmapper.IngresosRowMapper;
import com.tcs.app.model.Ingresos;

@Component
public class IngresosDaoImpl implements IngresosDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("${query.ingresos.create}")
	String queryCreate;
	
	@Value("${query.ingresos.list}")
	String queryList;
	
	@Value("${query.ingresos.delete}")
	String queryDelete;
	
	@Value("${query.ingresos.update}")
	String queryUpdate;
	
	@Value("${query.ingresos.get}")
	String queryGet;

	@Override
	public Ingresos create(Ingresos ingresos) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String query = queryCreate;
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection
					.prepareStatement(query);
			ps.setLong(1, ingresos.getEmpleado().getId());
			ps.setBigDecimal(2, ingresos.getMonto());
			return ps;
		}, keyHolder);
		
		Long idGenerado = (long) keyHolder.getKey().intValue();
		ingresos.setId(idGenerado);

		return ingresos;
	}

	@Override
	public List<Ingresos> list() {
		List<Ingresos> ingresosList = (List<Ingresos>) jdbcTemplate.query
				(queryList, new IngresosRowMapper());
		return ingresosList;
	}

	@Override
	public void delete(Long idIngresos) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(queryDelete, new Object[] {idIngresos});
	}

	@Override
	public Ingresos update(Ingresos ingresos) {
		// TODO Auto-generated method stub
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String query = queryUpdate;
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection
					.prepareStatement(query);
			ps.setLong(1, ingresos.getEmpleado().getId());
			ps.setBigDecimal(2, ingresos.getMonto());
			ps.setLong(3, ingresos.getId());
			return ps;
		}, keyHolder);
		
		return ingresos;
	}

	@Override
	public Ingresos get(Long idIngresos) {
		Ingresos ingresos = (Ingresos)jdbcTemplate
				.queryForObject(queryGet,
						new Object[] {idIngresos}, new IngresosRowMapper());

		return ingresos;
	}
	
}
