-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 02, 2024 at 09:47 AM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `colomboit`
--

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE IF NOT EXISTS `department` (
  `dep_id` int(10) NOT NULL AUTO_INCREMENT,
  `dep_name` varchar(10) NOT NULL,
  PRIMARY KEY (`dep_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`dep_id`, `dep_name`) VALUES
(1, 'DEV'),
(3, 'HR');

-- --------------------------------------------------------

--
-- Table structure for table `designation`
--

CREATE TABLE IF NOT EXISTS `designation` (
  `design_id` int(10) NOT NULL AUTO_INCREMENT,
  `design_name` varchar(30) NOT NULL,
  PRIMARY KEY (`design_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `designation`
--

INSERT INTO `designation` (`design_id`, `design_name`) VALUES
(3, 'Engineer'),
(5, 'QA'),
(6, 'Superviser');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `emp_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(50) NOT NULL,
  `emp_gender` varchar(10) NOT NULL,
  `emp_epf_num` int(15) NOT NULL,
  `emp_design` varchar(10) NOT NULL,
  `emp_dep` varchar(10) NOT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1010 ;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_id`, `emp_name`, `emp_gender`, `emp_epf_num`, `emp_design`, `emp_dep`) VALUES
(1000, 'dineth', 'male', 10400890, 'ENG', 'DEV'),
(1001, 'dhanuka', 'male', 10350600, 'DEV', 'DEV'),
(1002, 'kushal', 'male', 20560030, 'Superviser', 'HR'),
(1003, 'senuri', 'female', 1750020, 'MA', 'MKT');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `user_type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `username`, `password`, `user_type`) VALUES
(1, 'dineth', 'dineth', '1234', 'admin'),
(6, 'madawa', 'madawa', '4567', 'HRA'),
(7, 'ramya', 'ramya', '4567', 'HRA'),
(8, 'sahan gamage', 'gamage', '1234', 'HRM');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
