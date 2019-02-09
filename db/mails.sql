-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-02-2019 a las 21:23:11
-- Versión del servidor: 10.1.22-MariaDB
-- Versión de PHP: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mailprofiles`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `correos`
--

CREATE TABLE `correos` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(20) NOT NULL,
  `REMITENTE` varchar(255) DEFAULT NULL,
  `ALIASREMITENTE` varchar(255) DEFAULT NULL,
  `PASSREMITENTE` varchar(255) DEFAULT NULL,
  `ASUNTO` varchar(255) DEFAULT NULL,
  `URLTEMPLATE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `correos`
--

INSERT INTO `correos` (`ID`, `NOMBRE`, `REMITENTE`, `ALIASREMITENTE`, `PASSREMITENTE`, `ASUNTO`, `URLTEMPLATE`) VALUES
(1, 'Prueba', 'viewdevscompany@gmail.com', 'View Devs Company', 'd3sc4rg4r', 'Prueba', 'C:\\\\xampp\\\\htdocs\\\\upload\\\\adventureCenter\\\\mail.html');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `destinatarios`
--

CREATE TABLE `destinatarios` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `direccion` text NOT NULL,
  `fkCorreo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `destinatarios`
--

INSERT INTO `destinatarios` (`ID`, `NOMBRE`, `direccion`, `fkCorreo`) VALUES
(1, 'Nico', 'nico.grossi4@gmail.com', 1),
(4, 'ViewDevs', 'viewdevscompany@gmail.com', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `relacionescorreodestinatario`
--

CREATE TABLE `relacionescorreodestinatario` (
  `ID` int(11) NOT NULL,
  `fkCorreo` int(11) DEFAULT NULL,
  `fkDestinatario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `relacionescorreodestinatario`
--

INSERT INTO `relacionescorreodestinatario` (`ID`, `fkCorreo`, `fkDestinatario`) VALUES
(1, 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `correos`
--
ALTER TABLE `correos`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `destinatarios`
--
ALTER TABLE `destinatarios`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fkCorreo` (`fkCorreo`);

--
-- Indices de la tabla `relacionescorreodestinatario`
--
ALTER TABLE `relacionescorreodestinatario`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_relacionesCorreoDestinatario_fkCorreo` (`fkCorreo`),
  ADD KEY `FK_relacionesCorreoDestinatario_fkDestinatario` (`fkDestinatario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `correos`
--
ALTER TABLE `correos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `destinatarios`
--
ALTER TABLE `destinatarios`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `relacionescorreodestinatario`
--
ALTER TABLE `relacionescorreodestinatario`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `destinatarios`
--
ALTER TABLE `destinatarios`
  ADD CONSTRAINT `destinatarios_ibfk_1` FOREIGN KEY (`fkCorreo`) REFERENCES `correos` (`ID`);

--
-- Filtros para la tabla `relacionescorreodestinatario`
--
ALTER TABLE `relacionescorreodestinatario`
  ADD CONSTRAINT `FK_relacionesCorreoDestinatario_fkCorreo` FOREIGN KEY (`fkCorreo`) REFERENCES `correos` (`ID`),
  ADD CONSTRAINT `FK_relacionesCorreoDestinatario_fkDestinatario` FOREIGN KEY (`fkDestinatario`) REFERENCES `destinatarios` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
