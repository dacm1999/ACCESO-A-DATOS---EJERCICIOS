-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 27, 2023 at 02:49 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `medicos`
--

CREATE TABLE `medicos` (
  `NUMCOLEGIADO` int(5) NOT NULL,
  `NOMBRE` varchar(30) NOT NULL,
  `MAXPACIENTES` int(5) NOT NULL,
  `ESPECIALIDAD` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `medicos`
--

INSERT INTO `medicos` (`NUMCOLEGIADO`, `NOMBRE`, `MAXPACIENTES`, `ESPECIALIDAD`) VALUES
(1035, 'SERGIO', 250, 'TRAUMATOLOGIA'),
(2010, 'Diana', 230, 'MEDICO DE CABECERA'),
(2098, 'Alfonso', 200, 'NEUROLOGIA');

-- --------------------------------------------------------

--
-- Table structure for table `pacientes`
--

CREATE TABLE `pacientes` (
  `NUMPACIENTE` int(5) NOT NULL,
  `NOMBRE` varchar(30) NOT NULL,
  `APELLIDO` varchar(30) NOT NULL,
  `NUMCOLEGIADO` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pacientes`
--

INSERT INTO `pacientes` (`NUMPACIENTE`, `NOMBRE`, `APELLIDO`, `NUMCOLEGIADO`) VALUES
(307, 'Jorge', 'Duron', 2098),
(703, 'Nicole', 'Rojas', 2098),
(1034, 'Rafel', 'Anguila', 2010),
(1124, 'Margarita', 'Casado', 2098),
(1201, 'Mery', 'Lopez 2010', 2098),
(1532, 'Daniel', 'Contreras 2010', 2010),
(2901, 'Luis', 'Gomez 2010', 2098),
(3512, 'Alejandro', 'Mejia 2010', 2010),
(5678, 'Elsa', 'Casado', 2010);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `medicos`
--
ALTER TABLE `medicos`
  ADD PRIMARY KEY (`NUMCOLEGIADO`);

--
-- Indexes for table `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`NUMPACIENTE`),
  ADD KEY `NUMCOLEGIADO` (`NUMCOLEGIADO`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pacientes`
--
ALTER TABLE `pacientes`
  ADD CONSTRAINT `pacientes_ibfk_1` FOREIGN KEY (`NUMCOLEGIADO`) REFERENCES `medicos` (`NUMCOLEGIADO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
