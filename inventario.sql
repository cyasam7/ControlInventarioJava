-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-05-2020 a las 04:43:46
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inventario`
--
CREATE DATABASE IF NOT EXISTS `inventario` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `inventario`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `domareas`
--

CREATE TABLE IF NOT EXISTS `domareas` (
  `Area` varchar(45) NOT NULL,
  PRIMARY KEY (`Area`),
  UNIQUE KEY `Area_UNIQUE` (`Area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `domareas`
--

INSERT INTO `domareas` (`Area`) VALUES
('Limpieza'),
('Liquida');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `domareatrabajadores`
--

CREATE TABLE IF NOT EXISTS `domareatrabajadores` (
  `Area` varchar(45) NOT NULL,
  PRIMARY KEY (`Area`),
  UNIQUE KEY `area_UNIQUE` (`Area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `domareatrabajadores`
--

INSERT INTO `domareatrabajadores` (`Area`) VALUES
('C piso 1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `domturno`
--

CREATE TABLE IF NOT EXISTS `domturno` (
  `Turno` varchar(45) NOT NULL,
  PRIMARY KEY (`Turno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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

CREATE TABLE IF NOT EXISTS `historialpersonas` (
  `idHistorialPersona` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Apellido` varchar(45) NOT NULL,
  `Matricula` varchar(45) NOT NULL,
  `CodigoProducto` varchar(45) NOT NULL,
  `Entrego` varchar(45) NOT NULL DEFAULT 'No entrego',
  `Folio` varchar(45) NOT NULL,
  `CantidadProducto` int(11) NOT NULL,
  `Fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `FechaEntrego` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`idHistorialPersona`),
  KEY `HistorialPProducto_idx` (`CodigoProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `historialpersonas`
--

INSERT INTO `historialpersonas` (`idHistorialPersona`, `Nombre`, `Apellido`, `Matricula`, `CodigoProducto`, `Entrego`, `Folio`, `CantidadProducto`, `Fecha`, `FechaEntrego`) VALUES
(3, 'Alexander', 'Serrano', '17041611', '201512210846', '', 'sdasdsad', 1, '2016-11-16 12:43:20', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historialtrabajadores`
--

CREATE TABLE IF NOT EXISTS `historialtrabajadores` (
  `idHistorial` int(11) NOT NULL AUTO_INCREMENT,
  `CodigoProducto` varchar(45) NOT NULL,
  `CodigoTrabajador` varchar(45) NOT NULL,
  `FechaEntrego` timestamp NULL DEFAULT NULL,
  `Entrego` varchar(45) NOT NULL DEFAULT 'No entrego',
  `Folio` varchar(45) NOT NULL,
  `CantidadProducto` int(11) NOT NULL,
  `Fecha` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`idHistorial`),
  KEY `HistorialTProducto_idx` (`CodigoProducto`),
  KEY `HistorialTTrabajador_idx` (`CodigoTrabajador`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `historialtrabajadores`
--

INSERT INTO `historialtrabajadores` (`idHistorial`, `CodigoProducto`, `CodigoTrabajador`, `FechaEntrego`, `Entrego`, `Folio`, `CantidadProducto`, `Fecha`) VALUES
(28, '7100', '15040432', NULL, 'No entrego', '022a5465-0c67-4e10-b68e-daf8f78a1277', 1, '2020-05-09 02:22:07'),
(29, '17000', '15040432', NULL, 'No entrego', '022a5465-0c67-4e10-b68e-daf8f78a1277', 1, '2020-05-09 02:22:07'),
(30, '10150', '15040432', NULL, 'No entrego', '022a5465-0c67-4e10-b68e-daf8f78a1277', 1, '2020-05-09 02:22:07');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Estado` varchar(45) NOT NULL,
  `Codigo` varchar(45) NOT NULL,
  `Area` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProducto`),
  UNIQUE KEY `Codigo_UNIQUE` (`Codigo`),
  KEY `domAreaProducto_idx` (`Area`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProducto`, `Nombre`, `Cantidad`, `Estado`, `Codigo`, `Area`) VALUES
(8, 'Jobon', 3, 'Bien', '17000', 'Liquida'),
(12, 'Jabon', 93, 'Bueno', '7100', 'Limpieza'),
(13, 'Jabon', 9, 'Bueno', '10150', 'Limpieza'),
(14, 'Caja', 3, 'Bueno', '201512210846', 'Limpieza');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tempoproductos`
--

CREATE TABLE IF NOT EXISTS `tempoproductos` (
  `idTempo` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `area` varchar(50) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`idTempo`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajadores`
--

CREATE TABLE IF NOT EXISTS `trabajadores` (
  `idTrabajador` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Apellido` varchar(45) NOT NULL,
  `Area` varchar(45) DEFAULT NULL,
  `Turno` varchar(45) NOT NULL,
  `Codigo` varchar(45) NOT NULL,
  PRIMARY KEY (`idTrabajador`),
  UNIQUE KEY `Codigo_UNIQUE` (`Codigo`),
  KEY `DomTurno_idx` (`Turno`),
  KEY `DomAreaTrabajo_idx` (`Area`),
  KEY `DomAreaTrabajador_idx` (`Area`),
  KEY `AreaParaTrabajador_idx` (`Area`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `trabajadores`
--

INSERT INTO `trabajadores` (`idTrabajador`, `Nombre`, `Apellido`, `Area`, `Turno`, `Codigo`) VALUES
(9, 'Alexander', 'Serrano', 'C piso 1', 'Matutino', '17041611'),
(10, 'Francisco', 'Freyre', 'C piso 1', 'Vespertino', '15040432');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `NombreCompleto` varchar(45) NOT NULL,
  `Usuario` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `TipoUsuario` varchar(45) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vhistorialpersonas`
-- (Véase abajo para la vista actual)
--
CREATE TABLE IF NOT EXISTS `vhistorialpersonas` (
`Nombre` varchar(45)
,`Apellido` varchar(45)
,`Matricula` varchar(45)
,`Producto` varchar(45)
,`CodigoProducto` varchar(45)
,`Cantidad` int(11)
,`fecha` timestamp
,`FechaEntrego` timestamp
,`entrego` varchar(45)
,`folio` varchar(45)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vhistorialtrabajador`
-- (Véase abajo para la vista actual)
--
CREATE TABLE IF NOT EXISTS `vhistorialtrabajador` (
`Nombre` varchar(45)
,`Apellido` varchar(45)
,`Area` varchar(45)
,`Turno` varchar(45)
,`Fecha` timestamp
,`Entrego` varchar(45)
,`Folio` varchar(45)
,`FechaEntrego` timestamp
,`Producto` varchar(45)
,`Cantidad` int(11)
,`Codigo` varchar(45)
);

-- --------------------------------------------------------

--
-- Estructura para la vista de `vhistorialpersonas` exportada como una tabla
--
DROP TABLE IF EXISTS `vhistorialpersonas`;
CREATE TABLE IF NOT EXISTS `vhistorialpersonas`(
    `Nombre` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
    `Apellido` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
    `Matricula` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
    `Producto` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
    `CodigoProducto` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
    `Cantidad` int(11) NOT NULL,
    `fecha` timestamp NOT NULL DEFAULT 'current_timestamp()',
    `FechaEntrego` timestamp DEFAULT NULL,
    `entrego` varchar(45) COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'No entrego',
    `folio` varchar(45) COLLATE utf8mb4_general_ci NOT NULL
);

-- --------------------------------------------------------

--
-- Estructura para la vista de `vhistorialtrabajador` exportada como una tabla
--
DROP TABLE IF EXISTS `vhistorialtrabajador`;
CREATE TABLE IF NOT EXISTS `vhistorialtrabajador`(
    `Nombre` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
    `Apellido` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
    `Area` varchar(45) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `Turno` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
    `Fecha` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
    `Entrego` varchar(45) COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'No entrego',
    `Folio` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
    `FechaEntrego` timestamp DEFAULT NULL,
    `Producto` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
    `Cantidad` int(11) NOT NULL,
    `Codigo` varchar(45) COLLATE utf8mb4_general_ci NOT NULL
);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historialpersonas`
--
ALTER TABLE `historialpersonas`
  ADD CONSTRAINT `HistorialPProducto` FOREIGN KEY (`CodigoProducto`) REFERENCES `productos` (`Codigo`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `domAreaProducto` FOREIGN KEY (`Area`) REFERENCES `domareas` (`Area`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Filtros para la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  ADD CONSTRAINT `domTrabjadorArea` FOREIGN KEY (`Area`) REFERENCES `domareatrabajadores` (`Area`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `domTurno` FOREIGN KEY (`Turno`) REFERENCES `domturno` (`Turno`) ON DELETE CASCADE ON UPDATE CASCADE;


--
-- Metadatos
--
USE `phpmyadmin`;

--
-- Metadatos para la tabla domareas
--

--
-- Metadatos para la tabla domareatrabajadores
--

--
-- Metadatos para la tabla domturno
--

--
-- Metadatos para la tabla historialpersonas
--

--
-- Metadatos para la tabla historialtrabajadores
--

--
-- Metadatos para la tabla productos
--

--
-- Volcado de datos para la tabla `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'inventario', 'productos', '{\"sorted_col\":\"`Nombre` ASC\"}', '2020-05-08 22:32:01');

--
-- Metadatos para la tabla tempoproductos
--

--
-- Volcado de datos para la tabla `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'inventario', 'tempoproductos', '{\"CREATE_TIME\":\"2020-05-07 16:41:59\",\"col_order\":[0,1,2,3,4],\"col_visib\":[1,1,1,1,1]}', '2020-05-08 22:16:40');

--
-- Metadatos para la tabla trabajadores
--

--
-- Metadatos para la tabla usuarios
--

--
-- Metadatos para la tabla vhistorialpersonas
--

--
-- Metadatos para la tabla vhistorialtrabajador
--

--
-- Metadatos para la base de datos inventario
--
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
