-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-02-2019 a las 02:00:04
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
-- Estructura de tabla para la tabla `mails`
--

CREATE TABLE `mails` (
  `ID` int(11) NOT NULL,
  `REMITENTE` varchar(255) DEFAULT NULL,
  `ALIASREMITENTE` varchar(255) DEFAULT NULL,
  `PASSREMITENTE` varchar(255) DEFAULT NULL,
  `ASUNTO` varchar(255) DEFAULT NULL,
  `URLTEMPLATE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `mails`
--

INSERT INTO `mails` (`ID`, `REMITENTE`, `ALIASREMITENTE`, `PASSREMITENTE`, `ASUNTO`, `URLTEMPLATE`) VALUES
(1, 'viewdevscompany@gmail.com', 'View Devs Company', 'd3sc4rg4r', 'Prueba', 'C:\\\\xampp\\\\htdocs\\\\upload\\\\adventureCenter\\\\mail.html');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `mails`
--
ALTER TABLE `mails`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `mails`
--
ALTER TABLE `mails`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
