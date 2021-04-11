<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Lista de Ingresos</h1>

<c:if test="${not empty error}">
 	${error}
</c:if>

<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Empleado</th>
		<th>Monto</th>
		<th>Editar</th>
		<th>Eliminar</th>
	</tr>
	<c:forEach var="ingreso" items="${listadoIngresos}">
		<tr>
			<td>${ingreso.id}</td>
			<td>${ingreso.empleado.nombre} ${ingreso.empleado.apellido}</td>
			<td>${ingreso.monto}</td>
			<td><a href="${pageContext.servletContext.contextPath}/ingresos/editar/${ingreso.id}">Editar</a></td>
			<td><a href="${pageContext.servletContext.contextPath}/ingresos/eliminar/${ingreso.id}">Eliminar</a></td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="${pageContext.servletContext.contextPath}/ingresos/nuevo">Agregar Nuevo Ingreso</a>