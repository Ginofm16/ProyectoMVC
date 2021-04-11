<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Lista de Empleados</h1>

<c:if test="${not empty error}">
 	${error}
</c:if>

<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>Edad</th>
		<th>Sexo</th>
		<th>Editar</th>
		<th>Eliminar</th>
	</tr>
	<c:forEach var="emp" items="${listadoEmpleado}">
		<tr>
			<td>${emp.id}</td>
			<td>${emp.nombre}</td>
			<td>${emp.apellido}</td>
			<td>${emp.edad}</td>
			<td>${emp.sexo}</td>
			<td><a href="${pageContext.servletContext.contextPath}/empleados/editar/${emp.id}">Editar</a></td>
			<td><a href="${pageContext.servletContext.contextPath}/empleados/eliminar/${emp.id}">Eliminar</a></td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="${pageContext.servletContext.contextPath}/empleados/nuevo">Agregar Nuevo Empleado</a>