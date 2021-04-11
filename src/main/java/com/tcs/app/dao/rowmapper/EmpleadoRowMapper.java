package com.tcs.app.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tcs.app.model.Empleado;

public class EmpleadoRowMapper implements RowMapper<Empleado>{
	/*consumir el resultado de la query y setear los atributos de los objetos a los que refiere.*/
	
	@Override
	public Empleado mapRow(ResultSet resultSet, int i) throws SQLException {
		Empleado empleado = new Empleado();
		empleado.setId(resultSet.getLong("ID"));
		empleado.setNombre(resultSet.getString("NOMBRE"));
		empleado.setApellido(resultSet.getString("APELLIDO"));
		empleado.setEdad(resultSet.getLong("EDAD"));
		empleado.setSexo(resultSet.getString("SEXO"));
		return empleado;
	}

	
}
