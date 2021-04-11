<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

	<div>
		<h1>Menu Principal</h1>
	</div>
	
	<div>
		<h2>Mantenimiento de Empleados</h2>
	</div>
	
	<div>
		<a href="empleados/nuevo">Agregar Empleado</a>
		<br>
		<a href="empleados/listar">Listar Empleados</a>
	</div>
	
	<div>
		<h2>Mantenimiento de Ingresos</h2>		
	</div>
	
	<div>
		<a href="ingresos/nuevo">Agregar Ingreso</a>
		<br>
		<a href="ingresos/listar">Listar Ingresos</a>
	</div>
	
	<div>
		<P>  La hora del servidor es:  ${serverTime}. </P>
	</div>
	
</body>
</html>