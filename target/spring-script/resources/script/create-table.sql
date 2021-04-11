--Tabla con empleado

CREATE TABLE `Empleado` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `edad` int(20) NOT NULL,
  `sexo` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
);

--Tabla detalle de ingresos de empleado

CREATE TABLE `Ingresos` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `idEmpleado` int(10) NOT NULL,
  `monto` DECIMAL(100,2) NOT NULL,
  PRIMARY KEY (`id`),
  foreign key (idEmpleado) references Empleado(id)
);