-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-03-2024 a las 18:32:59
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
  `daño` double NOT NULL,
  `peso` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `armas`
--

INSERT INTO `armas` (`id`, `nombre`, `daño`, `peso`) VALUES
(1, 'Estoque de Ricard', 70, 2),
(2, 'Zweihander', 140, 10),
(3, 'Espadón de luz de luna', 118, 4),
(4, 'Katana Uchigatana', 120, 6),
(5, 'Maza Estrella del alba', 100, 4),
(6, 'Alabarda de Caballero Negro', 245, 14),
(7, 'Ultra espadón del humo', 310, 25.5),
(8, 'Gran garrote', 154, 16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caballero`
--

CREATE TABLE `caballero` (
  `id` int(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `exp` varchar(3) NOT NULL,
  `fuerza` int(11) NOT NULL,
  `destreza` int(11) NOT NULL,
  `id_arma` int(255) NOT NULL,
  `id_escudo` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `caballero`
--

INSERT INTO `caballero` (`id`, `nombre`, `exp`, `fuerza`, `destreza`, `id_arma`, `id_escudo`) VALUES
(1, 'Siegmeyer de Catarina', '10', 20, 12, 2, 1),
(2, 'Solaire de Astora', '8', 13, 15, 3, 5),
(3, 'Havel la Roca', '15', 50, 2, 7, 3),
(4, 'Príncipe Ricard', '5', 2, 35, 1, 4),
(5, 'Yuria de Londor', '4', 10, 12, 6, 5),
(6, 'El Irrompible Parches', '7', 13, 13, 6, 3),
(7, 'Radahn el Azote de las Estrellas', '20', 45, 23, 7, 3),
(8, 'Malenia la Espada de Miquella', '20', 10, 40, 2, 6);

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

--
-- Volcado de datos para la tabla `caballos`
--

INSERT INTO `caballos` (`id`, `nombre`, `vMax`, `resistencia`, `id_caballero`) VALUES
(1, 'Leonard', 1.5, 1, 7),
(2, 'Vicente', 5, 10, 1),
(3, 'Perdigón', 10, 5, 4),
(4, 'Pegaso', 15.5, 12.2, 2),
(5, 'Bucéfalo', 7.5, 7.5, 5);

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

--
-- Volcado de datos para la tabla `escuderos`
--

INSERT INTO `escuderos` (`id`, `nombre`, `experiencia`, `fortaleza`, `id_caballero`) VALUES
(1, 'Pugmanche el guardián', 1, 45, 2),
(2, 'Gilberto el marionetas', 5, 50, 6),
(3, 'Ronbai bufón real', 5, 35, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escudos`
--

CREATE TABLE `escudos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `defensa` double NOT NULL,
  `peso` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `escudos`
--

INSERT INTO `escudos` (`id`, `nombre`, `defensa`, `peso`) VALUES
(1, 'Escudo redondo', 85, 1),
(2, 'Escudo de Caballero Negro', 100, 6),
(3, 'Gran escudo de Mante', 200, 12),
(4, 'Rodela', 76, 1.5),
(5, 'Escudo de hierro blanco', 187.5, 14.5),
(6, 'Escudo de emblema de hierba', 92, 0.5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `luchas`
--

CREATE TABLE `luchas` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `id_ganador` int(11) NOT NULL,
  `id_perdedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `luchas`
--

INSERT INTO `luchas` (`id`, `fecha`, `id_ganador`, `id_perdedor`) VALUES
(1, '2024-03-14', 1, 2),
(2, '2024-03-15', 3, 2),
(3, '2024-03-15', 7, 6),
(4, '2024-03-15', 2, 4),
(5, '2024-03-18', 2, 1);

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
  ADD KEY `id_ganador` (`id_ganador`),
  ADD KEY `id_caballero2` (`id_perdedor`),
  ADD KEY `id_ganador_2` (`id_ganador`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `armas`
--
ALTER TABLE `armas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `caballero`
--
ALTER TABLE `caballero`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `caballos`
--
ALTER TABLE `caballos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `escuderos`
--
ALTER TABLE `escuderos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `escudos`
--
ALTER TABLE `escudos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `luchas`
--
ALTER TABLE `luchas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

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
  ADD CONSTRAINT `luchas_ibfk_1` FOREIGN KEY (`id_ganador`) REFERENCES `caballero` (`id`),
  ADD CONSTRAINT `luchas_ibfk_2` FOREIGN KEY (`id_perdedor`) REFERENCES `caballero` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
