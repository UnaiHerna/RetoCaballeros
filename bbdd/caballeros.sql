-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-03-2024 a las 09:17:15
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `caballeros`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `armas`
--

CREATE TABLE `armas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `daño` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caballero`
--

CREATE TABLE `caballero` (
  `id` int(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `nivel` int(3) NOT NULL,
  `id_arma` int(255) NOT NULL,
  `id_escudo` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caballos`
--

CREATE TABLE `caballos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `vMax` double NOT NULL,
  `resistencia` double NOT NULL,
  `id_caballero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escuderos`
--

CREATE TABLE `escuderos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `experiencia` int(11) NOT NULL,
  `fortaleza` double NOT NULL,
  `id_caballero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escudos`
--

CREATE TABLE `escudos` (
  `id` int(11) NOT NULL,
  `nombre` int(11) NOT NULL,
  `defensa` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `luchas`
--

CREATE TABLE `luchas` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `id_caballero1` int(11) NOT NULL,
  `id_caballero2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `armas`
--
ALTER TABLE `armas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `caballero`
--
ALTER TABLE `caballero`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_arma` (`id_arma`),
  ADD KEY `id_escudo` (`id_escudo`);

--
-- Indices de la tabla `caballos`
--
ALTER TABLE `caballos`
  ADD PRIMARY KEY (`id`,`id_caballero`),
  ADD UNIQUE KEY `id_caballero_2` (`id_caballero`),
  ADD KEY `id_caballero` (`id_caballero`);

--
-- Indices de la tabla `escuderos`
--
ALTER TABLE `escuderos`
  ADD PRIMARY KEY (`id`,`id_caballero`),
  ADD UNIQUE KEY `id_caballero_2` (`id_caballero`),
  ADD KEY `id_caballero` (`id_caballero`);

--
-- Indices de la tabla `escudos`
--
ALTER TABLE `escudos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `luchas`
--
ALTER TABLE `luchas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_ganador` (`id_caballero1`),
  ADD KEY `id_caballero2` (`id_caballero2`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `armas`
--
ALTER TABLE `armas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `caballero`
--
ALTER TABLE `caballero`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `caballos`
--
ALTER TABLE `caballos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `escuderos`
--
ALTER TABLE `escuderos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `escudos`
--
ALTER TABLE `escudos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `luchas`
--
ALTER TABLE `luchas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `caballero`
--
ALTER TABLE `caballero`
  ADD CONSTRAINT `caballero_ibfk_5` FOREIGN KEY (`id_escudo`) REFERENCES `escudos` (`id`),
  ADD CONSTRAINT `caballero_ibfk_6` FOREIGN KEY (`id_arma`) REFERENCES `armas` (`id`);

--
-- Filtros para la tabla `caballos`
--
ALTER TABLE `caballos`
  ADD CONSTRAINT `caballos_ibfk_1` FOREIGN KEY (`id_caballero`) REFERENCES `caballero` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `escuderos`
--
ALTER TABLE `escuderos`
  ADD CONSTRAINT `escuderos_ibfk_1` FOREIGN KEY (`id_caballero`) REFERENCES `caballero` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `luchas`
--
ALTER TABLE `luchas`
  ADD CONSTRAINT `luchas_ibfk_1` FOREIGN KEY (`id_caballero1`) REFERENCES `caballero` (`id`),
  ADD CONSTRAINT `luchas_ibfk_2` FOREIGN KEY (`id_caballero2`) REFERENCES `caballero` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
