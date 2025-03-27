-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 18, 2025 at 07:59 AM
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
-- Database: `dhpapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `u_id` int(11) NOT NULL,
  `u_fname` varchar(55) NOT NULL,
  `u_lname` varchar(55) NOT NULL,
  `u_username` varchar(55) NOT NULL,
  `u_password` varchar(55) NOT NULL,
  `u_email` varchar(55) NOT NULL,
  `u_age` int(55) NOT NULL,
  `u_type` varchar(55) NOT NULL,
  `u_status` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_fname`, `u_lname`, `u_username`, `u_password`, `u_email`, `u_age`, `u_type`, `u_status`) VALUES
(1, 'test', 'test', 'test', '12345678', 'test@gmail.com', 40, 'Patient', 'Active'),
(2, 'test2', 'test2', 'test2', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'test2@gmail.com', 20, 'Admin', 'Active'),
(3, 'a', 'a', 'a', '12345678', 'a@gmail.com', 12, 'Admin', 'Active'),
(4, 'destinado', 'b', 'Choy1', 'a0VX3KCa1TD/9hAATGyRjLwwww2rs8WjD1ThvDe9zxg=', 'ddd@gmail.com', 50, 'Medical Staff', 'Active'),
(5, 'test', 'test', 'test3', '12345678', 'test3@gmail.com', 12, 'Admin', 'Pending'),
(6, 'test', 'test', 'test4', '12345678', 'test4@gmail.com', 12, 'Admin', 'Pending'),
(7, 'test', 'test', 'test5', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'test5@gmail.com', 12, 'Admin', 'Pending');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
