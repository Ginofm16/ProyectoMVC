<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>${accion == 'nuevo' ? 'Crear' : 'Editar'} Empleado</h1>

<form method="POST" action="${pageContext.servletContext.contextPath}/empleados/guardar">
	<table>
		<tr>
			<td></td>
			<td><input type="hidden" name="id" value="${empleado.id}"></td>
		</tr>
		<tr>
			<td>Nombre :</td>
			<td><input name="nombre" value="${empleado.nombre}"></td>
		</tr>
		<tr>
			<td>Apellido :</td>
			<td><input name="apellido" value="${empleado.apellido}"></td>
		</tr>
		<tr>
			<td>Edad :</td>
			<td><input name="edad" value="${empleado.edad}"></td>
		</tr>
		<tr>
			<td>Sexo :</td>
			<td><input name="sexo" value="${empleado.sexo}"></td>
		</tr>

		<tr>
			<td></td>
			<td><input type="submit" value="Guardar" /></td>
		</tr>
	</table>
</form>