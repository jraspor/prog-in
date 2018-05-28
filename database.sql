-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 26, 2018 at 06:43 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database`
--

-- --------------------------------------------------------

--
-- Table structure for table `javni_pod`
--

CREATE TABLE `javni_pod` (
  `name` varchar(200) NOT NULL,
  `path` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `javni_pod`
--

INSERT INTO `javni_pod` (`name`, `path`) VALUES
('Vote', 'C:\\xampp\\htdocs\\javni_podaci\\vote.arff'),
('Glass', 'C:\\xampp\\htdocs\\javni_podaci\\glass.arff'),
('Soybean', 'C:\\xampp\\htdocs\\javni_podaci\\soybean.arff'),
('Labor', 'C:\\xampp\\htdocs\\javni_podaci\\labor.arff'),
('Iris', 'C:\\xampp\\htdocs\\javni_podaci\\iris.arff'),
('Weather', 'C:\\xampp\\htdocs\\javni_podaci\\weather.arff'),
('ReutersCorn-train', 'C:\\xampp\\htdocs\\javni_podaci\\ReutersCorn-train.arff');

-- --------------------------------------------------------

--
-- Table structure for table `klasifikatori`
--

CREATE TABLE `klasifikatori` (
  `name` varchar(200) NOT NULL,
  `path` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `klasifikatori`
--

INSERT INTO `klasifikatori` (`name`, `path`) VALUES
('CheckClassifier', 'C:\\xampp\\htdocs\\klasifikatori\\CheckClassifier.java'),
('CostMatrix', 'C:\\xampp\\htdocs\\klasifikatori\\CostMatrix.java');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
