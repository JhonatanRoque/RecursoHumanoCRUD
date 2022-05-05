-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-05-2022 a las 18:06:04
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_recurso_humano`
--
CREATE DATABASE bd_recurso_humano;
Use bd_recurso_humano;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_contacto`
--

CREATE TABLE `tb_contacto` (
  `id_contacto` int(11) NOT NULL,
  `nom_contacto` varchar(45) DEFAULT NULL,
  `email_contacto` varchar(45) DEFAULT NULL,
  `tel_contacto` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_estudiante`
--

CREATE TABLE `tb_estudiante` (
  `id_estudiante` int(11) NOT NULL,
  `carnet_estudiante` varchar(16) DEFAULT NULL,
  `nom_estudiante` varchar(30) DEFAULT NULL,
  `ape_estudiante` varchar(30) DEFAULT NULL,
  `edad_estudiante` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_estudiante`
--

INSERT INTO `tb_estudiante` (`id_estudiante`, `carnet_estudiante`, `nom_estudiante`, `ape_estudiante`, `edad_estudiante`) VALUES
(1001, '987p', 'jonatan', 'abarca', 19);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_persona`
--

CREATE TABLE `tb_persona` (
  `dui_persona` varchar(10) NOT NULL,
  `apellidos_persona` varchar(30) DEFAULT NULL,
  `nombre_persona` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tb_contacto`
--
ALTER TABLE `tb_contacto`
  ADD PRIMARY KEY (`id_contacto`);

--
-- Indices de la tabla `tb_estudiante`
--
ALTER TABLE `tb_estudiante`
  ADD PRIMARY KEY (`id_estudiante`);

--
-- Indices de la tabla `tb_persona`
--
ALTER TABLE `tb_persona`
  ADD PRIMARY KEY (`dui_persona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_contacto`
--
ALTER TABLE `tb_contacto`
  MODIFY `id_contacto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tb_estudiante`
--
ALTER TABLE `tb_estudiante`
  MODIFY `id_estudiante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1002;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
