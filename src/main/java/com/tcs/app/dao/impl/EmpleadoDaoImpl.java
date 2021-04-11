package com.tcs.app.dao.impl;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.tcs.app.dao.EmpleadoDao;
import com.tcs.app.dao.rowmapper.EmpleadoRowMapper;
import com.tcs.app.model.Empleado;

@Component
public class EmpleadoDaoImpl implements EmpleadoDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("${query.empleado.create}")
	String queryCreate;
	
	@Value("${query.empleado.list}")
	String queryList;
	
	@Value("${query.empleado.delete}")
	String queryDelete;
	
	@Value("${query.empleado.update}")
	String queryUpdate;
	
	@Value("${query.empleado.get}")
	String queryGet;

	@Override
	public Empleado create(Empleado empleado) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String query = queryCreate;
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection
					.prepareStatement(query);
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellido());
			ps.setLong(3, empleado.getEdad());
			ps.setString(4, empleado.getSexo());
			return ps;
		}, keyHolder);
		
		Long idGenerado = (long) keyHolder.getKey().intValue();
		empleado.setId(idGenerado);

		return empleado;
	}

	@Override
	public List<Empleado> list() {
		List<Empleado> empleadoList = (List<Empleado>) jdbcTemplate.query
				(queryList, new EmpleadoRowMapper());
		return empleadoList;
	}

	@Override
	public void delete(Long idEmpleado) {
		jdbcTemplate.update(queryDelete, new Object[] {idEmpleado});
		
	}

	@Override
	public Empleado update(Empleado empleado) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String query = queryUpdate;
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection
					.prepareStatement(query);
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellido());
			ps.setLong(3, empleado.getEdad());
			ps.setString(4, empleado.getSexo());
			ps.setLong(5, empleado.getId());
			return ps;
		}, keyHolder);
		
		return empleado;
	}

	@Override
	public Empleado get(Long idEmpleado) {
		Empleado empleado = (Empleado)jdbcTemplate
				.queryForObject(queryGet,
						new Object[] {idEmpleado}, new EmpleadoRowMapper());

		return empleado;
	}
	
}
