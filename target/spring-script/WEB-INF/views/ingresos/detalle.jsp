<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>${accion == 'nuevo' ? 'Crear' : 'Editar'} Ingreso a Empleado</h1>

<form method="POST" action="${pageContext.servletContext.contextPath}/ingresos/guardar">
	<table>
		<tr>
			<td></td>
			<td><input type="hidden" name="id" value="${ingresos.id}"></td>
		</tr>
		<tr>
			<td>Empleado :</td>
			<td>
				<select name="empleado.id">
				    <option>Selecciona Empleado</option>
				    <c:forEach items="${listadoEmpleado}" var="empleado">
						<option value="${empleado.id}" ${(empleado.id == ingresos.empleado.id)?'selected':''}>${empleado.nombre} ${empleado.apellido}</option>
				    	</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>Monto :</td>
			<td><input name="monto" value="${ingresos.monto}"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Guardar" /></td>
		</tr>
	</table>
</form>