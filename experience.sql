-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 07, 2024 at 07:24 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `experience`
--

-- --------------------------------------------------------

--
-- Table structure for table `experience`
--

CREATE TABLE `experience` (
  `id` int(11) NOT NULL,
  `company` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `experience`
--

INSERT INTO `experience` (`id`, `company`, `description`, `end_date`, `position`, `start_date`, `title`) VALUES
(1, 'Agence Urbaine de Marrakech', 'analys, conception et development', '2023-09-18 01:00:00.000000', 'Marrakech', '2023-07-17 01:00:00.000000', 'Stage');

-- --------------------------------------------------------

--
-- Table structure for table `experience_skills`
--

CREATE TABLE `experience_skills` (
  `experience_id` int(11) NOT NULL,
  `skills` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `experience_skills`
--

INSERT INTO `experience_skills` (`experience_id`, `skills`) VALUES
(1, 'python'),
(1, 'Django'),
(1, 'JavaScript'),
(1, 'bootstrap'),
(1, 'html'),
(1, 'css'),
(1, 'MySQL');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `experience`
--
ALTER TABLE `experience`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `experience_skills`
--
ALTER TABLE `experience_skills`
  ADD KEY `FKqu01wblas164c21wdm3jfa5ku` (`experience_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `experience`
--
ALTER TABLE `experience`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `experience_skills`
--
ALTER TABLE `experience_skills`
  ADD CONSTRAINT `FKqu01wblas164c21wdm3jfa5ku` FOREIGN KEY (`experience_id`) REFERENCES `experience` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
