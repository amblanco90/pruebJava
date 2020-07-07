-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-07-2020 a las 23:09:11
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prueba`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pqr`
--

CREATE TABLE `pqr` (
  `id` int(11) NOT NULL,
  `Tipo` varchar(300) NOT NULL,
  `Asunto` mediumtext NOT NULL,
  `Estado` varchar(100) NOT NULL,
  `FechaCreacion` varchar(100) NOT NULL,
  `FechaLimite` varchar(100) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pqr`
--

INSERT INTO `pqr` (`id`, `Tipo`, `Asunto`, `Estado`, `FechaCreacion`, `FechaLimite`, `idUsuario`) VALUES
(6, 'Peticion', 'ifj3io4nfi43nifn', 'Cerrado', '07/07/2020', '07/07/2020', 1234567890),
(7, 'Reclamo', 'eionfioernnernoi', 'Cerrado', '07/07/2020', '09/07/2020', 1234567890),
(10, 'Peticion', 'uhiuhiu', 'Nuevo', '07/07/2020', '14/07/2020', 987554245);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Nombre` varchar(200) NOT NULL,
  `Documento` int(20) NOT NULL,
  `Contraseña` varchar(50) NOT NULL,
  `Rol` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`Nombre`, `Documento`, `Contraseña`, `Rol`) VALUES
('789798789797', 45678900, '74765765757', 'User'),
('hjkhkjfghjkgh', 987554245, 'gdgfgdsjfhgdsh', 'User'),
('Alexandra Blanco', 1002158209, '12345678', 'User'),
('1234567890', 1234567890, '12345678', 'Admin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pqr`
--
ALTER TABLE `pqr`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Documento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pqr`
--
ALTER TABLE `pqr`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pqr`
--
ALTER TABLE `pqr`
  ADD CONSTRAINT `pqr_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`Documento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
