-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3308
-- Tiempo de generación: 02-05-2020 a las 03:57:37
-- Versión del servidor: 8.0.18
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inventario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `domareas`
--

DROP TABLE IF EXISTS `domareas`;
CREATE TABLE IF NOT EXISTS `domareas` (
  `Area` varchar(45) NOT NULL,
  PRIMARY KEY (`Area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `domareas`
--

INSERT INTO `domareas` (`Area`) VALUES
('Area'),
('dasdas'),
('Limpieza');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `domturno`
--

DROP TABLE IF EXISTS `domturno`;
CREATE TABLE IF NOT EXISTS `domturno` (
  `Turno` varchar(45) NOT NULL,
  PRIMARY KEY (`Turno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `domturno`
--

INSERT INTO `domturno` (`Turno`) VALUES
('Matutino'),
('Vespertino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historialpersonas`
--

DROP TABLE IF EXISTS `historialpersonas`;
CREATE TABLE IF NOT EXISTS `historialpersonas` (
  `idHistorialPersona` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Apellido` varchar(45) NOT NULL,
  `Descripcion` text NOT NULL,
  `CodigoProducto` varchar(45) NOT NULL,
  `CantidadProducto` int(11) NOT NULL,
  `Fecha` timestamp NOT NULL,
  `Entrego` varchar(45) NOT NULL DEFAULT 'No entrego',
  `Folio` varchar(45) NOT NULL,
  PRIMARY KEY (`idHistorialPersona`),
  KEY `HistorialPProducto_idx` (`CodigoProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `historialpersonas`
--

INSERT INTO `historialpersonas` (`idHistorialPersona`, `Nombre`, `Apellido`, `Descripcion`, `CodigoProducto`, `CantidadProducto`, `Fecha`, `Entrego`, `Folio`) VALUES
(1, 'Alexander ', 'Serrano', 'Alumno ', 'dsa', 2, '2016-11-16 12:43:20', 'No entrego', '1561515'),
(4, 'Alexander', 'Serrano', 'dasdas', '0001', 1, '2020-05-01 19:27:47', 'No entrego', '78840650-20cc-4ae4-b411-6c8c86b071f1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historialtrabajadores`
--

DROP TABLE IF EXISTS `historialtrabajadores`;
CREATE TABLE IF NOT EXISTS `historialtrabajadores` (
  `idHistorial` int(11) NOT NULL AUTO_INCREMENT,
  `CodigoProducto` varchar(45) NOT NULL,
  `CodigoTrabajador` varchar(45) NOT NULL,
  `Fecha` timestamp NOT NULL,
  `Entrego` varchar(45) NOT NULL DEFAULT 'No entrego',
  `Folio` varchar(45) NOT NULL,
  `CantidadProducto` int(11) NOT NULL,
  PRIMARY KEY (`idHistorial`),
  KEY `HistorialTProducto_idx` (`CodigoProducto`),
  KEY `HistorialTTrabajador_idx` (`CodigoTrabajador`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `historialtrabajadores`
--

INSERT INTO `historialtrabajadores` (`idHistorial`, `CodigoProducto`, `CodigoTrabajador`, `Fecha`, `Entrego`, `Folio`, `CantidadProducto`) VALUES
(3, 'dsa', '17041611', '2016-11-16 12:43:20', 'No entrego', '17041611', 2),
(4, 'dsa', '17041611', '2016-11-16 12:43:20', 'No entrego', '17041612', 1),
(7, 'dsa', '17041611', '2020-05-01 18:55:05', 'No entrego', '4eb98d6f-7b76-4738-8a60-3a1654613c25', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE IF NOT EXISTS `productos` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Estado` varchar(45) NOT NULL,
  `Codigo` varchar(45) NOT NULL,
  `Area` varchar(45) NOT NULL,
  PRIMARY KEY (`idProducto`),
  UNIQUE KEY `Codigo_UNIQUE` (`Codigo`),
  KEY `ProductoArea_idx` (`Area`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProducto`, `Nombre`, `Cantidad`, `Estado`, `Codigo`, `Area`) VALUES
(4, 'sad', 1, 'das', 'dsa', 'Area'),
(6, 'Jabon', 2, 'Nuevo', '0001', 'Limpieza');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajadores`
--

DROP TABLE IF EXISTS `trabajadores`;
CREATE TABLE IF NOT EXISTS `trabajadores` (
  `idTrabajador` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Apellido` varchar(45) NOT NULL,
  `Area` varchar(45) NOT NULL,
  `Turno` varchar(45) NOT NULL,
  `Codigo` varchar(45) NOT NULL,
  PRIMARY KEY (`idTrabajador`),
  UNIQUE KEY `Codigo_UNIQUE` (`Codigo`),
  KEY `DomArea_idx` (`Area`),
  KEY `DomTurno_idx` (`Turno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `trabajadores`
--

INSERT INTO `trabajadores` (`idTrabajador`, `Nombre`, `Apellido`, `Area`, `Turno`, `Codigo`) VALUES
(3, 'Alexander', 'Serrano', 'Limpieza', 'Matutino', '17041611');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `NombreCompleto` varchar(45) NOT NULL,
  `Usuario` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `TipoUsuario` varchar(45) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vhistorialpersonas`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vhistorialpersonas`;
CREATE TABLE IF NOT EXISTS `vhistorialpersonas` (
`Apellido` varchar(45)
,`Cantidad` int(11)
,`CodigoProducto` varchar(45)
,`Descripcion` text
,`entrego` varchar(45)
,`fecha` timestamp
,`folio` varchar(45)
,`Nombre` varchar(45)
,`Producto` varchar(45)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vhistorialtrabajador`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vhistorialtrabajador`;
CREATE TABLE IF NOT EXISTS `vhistorialtrabajador` (
`Apellido` varchar(45)
,`Area` varchar(45)
,`Cantidad` int(11)
,`Codigo` varchar(45)
,`Entrego` varchar(45)
,`Fecha` timestamp
,`Folio` varchar(45)
,`Nombre` varchar(45)
,`Producto` varchar(45)
,`Turno` varchar(45)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vhistorialpersonas`
--
DROP TABLE IF EXISTS `vhistorialpersonas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vhistorialpersonas`  AS  select `hp`.`Nombre` AS `Nombre`,`hp`.`Apellido` AS `Apellido`,`hp`.`Descripcion` AS `Descripcion`,`p`.`Nombre` AS `Producto`,`p`.`Codigo` AS `CodigoProducto`,`hp`.`CantidadProducto` AS `Cantidad`,`hp`.`Fecha` AS `fecha`,`hp`.`Entrego` AS `entrego`,`hp`.`Folio` AS `folio` from (`historialpersonas` `hp` join `productos` `p`) where (`hp`.`CodigoProducto` = `p`.`Codigo`) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vhistorialtrabajador`
--
DROP TABLE IF EXISTS `vhistorialtrabajador`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vhistorialtrabajador`  AS  select `tb`.`Nombre` AS `Nombre`,`tb`.`Apellido` AS `Apellido`,`tb`.`Area` AS `Area`,`tb`.`Turno` AS `Turno`,`t`.`Fecha` AS `Fecha`,`t`.`Entrego` AS `Entrego`,`t`.`Folio` AS `Folio`,`p`.`Nombre` AS `Producto`,`t`.`CantidadProducto` AS `Cantidad`,`p`.`Codigo` AS `Codigo` from ((`historialtrabajadores` `t` join `trabajadores` `tb`) join `productos` `p`) where ((`t`.`CodigoTrabajador` = `tb`.`Codigo`) and (`t`.`CodigoProducto` = `p`.`Codigo`)) ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historialpersonas`
--
ALTER TABLE `historialpersonas`
  ADD CONSTRAINT `HistorialPProducto` FOREIGN KEY (`CodigoProducto`) REFERENCES `productos` (`Codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `historialtrabajadores`
--
ALTER TABLE `historialtrabajadores`
  ADD CONSTRAINT `HistorialTProducto` FOREIGN KEY (`CodigoProducto`) REFERENCES `productos` (`Codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `HistorialTTrabajador` FOREIGN KEY (`CodigoTrabajador`) REFERENCES `trabajadores` (`Codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `ProductoArea` FOREIGN KEY (`Area`) REFERENCES `domareas` (`Area`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Filtros para la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  ADD CONSTRAINT `DomArea` FOREIGN KEY (`Area`) REFERENCES `domareas` (`Area`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `DomTurno` FOREIGN KEY (`Turno`) REFERENCES `domturno` (`Turno`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
