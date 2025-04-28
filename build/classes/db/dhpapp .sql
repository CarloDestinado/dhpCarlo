-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 28, 2025 at 04:40 PM
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
-- Table structure for table `tbl_diagnosis`
--

CREATE TABLE `tbl_diagnosis` (
  `d_id` int(11) NOT NULL,
  `patient` varchar(255) NOT NULL,
  `diagnosis` varchar(255) NOT NULL,
  `doctor` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_diagnosis`
--

INSERT INTO `tbl_diagnosis` (`d_id`, `patient`, `diagnosis`, `doctor`) VALUES
(1, 'carlo', 'sakit sa tuhod', ''),
(2, 'carlo', 'sakit sa tuhod', ''),
(3, 'carlo', 'carlo', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_log`
--

CREATE TABLE `tbl_log` (
  `log_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `u_username` varchar(50) NOT NULL,
  `login_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `u_type` varchar(50) NOT NULL,
  `log_status` enum('Pending','Active','Inactive','') NOT NULL,
  `logout_time` timestamp NULL DEFAULT NULL,
  `log_description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_log`
--

INSERT INTO `tbl_log` (`log_id`, `u_id`, `u_username`, `login_time`, `u_type`, `log_status`, `logout_time`, `log_description`) VALUES
(160, 35, 'qwee', '2025-04-28 00:57:53', 'Admin', 'Inactive', '2025-04-28 03:43:36', 'Admin Added a New Account: meow'),
(161, 35, 'qwee', '2025-04-28 01:52:54', 'Admin', 'Inactive', '2025-04-28 03:43:36', 'Deleted user account with ID: 37'),
(162, 40, 'doctor', '2025-04-28 01:55:09', 'Success - User Action', 'Active', NULL, 'New user registered: doctor'),
(163, 40, 'doctor', '2025-04-28 04:03:22', 'Success - User Action', 'Active', NULL, 'User Changed Their Password'),
(164, 40, 'doctor', '2025-04-28 04:29:55', 'Medical Staff', 'Active', NULL, 'User Changed Their Details'),
(165, 35, 'qwee', '2025-04-28 07:41:16', 'Admin', 'Inactive', '2025-04-28 07:42:58', 'Deleted user account with ID: 39'),
(166, 35, 'qwee', '2025-04-28 07:42:53', 'Admin', 'Inactive', '2025-04-28 07:42:58', 'Admin Added a New Account: merry'),
(167, 35, 'qwee', '2025-04-28 07:56:54', 'Admin', 'Active', NULL, 'Admin Added a New Account: patient'),
(168, 43, 'tibok', '2025-04-28 11:53:54', 'Success - User Action', 'Active', NULL, 'New user registered: tibok');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_specialty`
--

CREATE TABLE `tbl_specialty` (
  `s_id` int(11) NOT NULL,
  `s_specialty` varchar(255) NOT NULL,
  `u_id` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_specialty`
--

INSERT INTO `tbl_specialty` (`s_id`, `s_specialty`, `u_id`) VALUES
(4, 'tig hilot', 40);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `u_id` int(11) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_username` varchar(255) NOT NULL,
  `u_password` varchar(50) NOT NULL,
  `u_type` varchar(50) NOT NULL,
  `u_status` varchar(50) NOT NULL,
  `security_question` varchar(255) NOT NULL,
  `security_answer` varchar(255) NOT NULL,
  `u_image` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_username`, `u_password`, `u_type`, `u_status`, `security_question`, `security_answer`, `u_image`) VALUES
(35, 'qwe', 'qweqwe', 'qwe@gmail.com', 'qwee', 'DR6kwlbNUKKnzL/SKz2ZWfb9ML2EC5/zx8Ze5OId8G0=', 'Admin', 'Active', 'What\'s the name of your First pet?', 'DR6kwlbNUKKnzL/SKz2ZWfb9ML2EC5/zx8Ze5OId8G0=', 'src/images/backiee-98927-landscape.jpg'),
(36, 'asdasd', 'asdasd', '123@gmail.com', 'asd', 'ky88G1YlfOhTmsJp16q0JVDaz4gY0HXwvfGZBWKq4+8=', 'Patient', 'Active', 'What\'s the name of your First pet?', 'zUbeBghXPckSGy8/y/h6xipRM9kr4ZerWcxmsqrPQ7s=', 'Null'),
(38, 'qwer', 'qwer', 'qwer@gmail.com', 'qwer', 'cPmAePssfXv7OuFzMLkeqgGBELA4lpebTIi/rtOAWQY=', 'Active', 'Admin', 'What\'s the name of your first pet?', 'FDPWiFkJAwQSCrM8VSNIVJKiTeaEZIELdwpZV7bWTKE=', 'qwer_backiee-217218-landscape.jpg'),
(40, 'doc', 'tor', 'doc@gmail.com', 'doctor', '0mdfhcTmiPpPz6rLm7TDzugR3GK+enovXRN3nDF+bAk=', 'Medical Staff', 'Active', 'What\'s the name of your First pet?', 'WO3eh5s4MwUck8f+wARHnbZpav/WSbro28qxTxVwqmE=', 'src/images/backiee-98927-landscape.jpg'),
(41, 'merry', 'joyce', 'm@gmail.com', 'merry', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Active', 'Patient', 'What\'s the name of your first pet?', '1ZTK7mu0xiIVQO4khZ9KJrB1cl9iwfprZz6eBnS2h3U=', 'merry_backiee-98927-landscape.jpg'),
(42, 'a', 'a', 'a@gmail', 'patient', 'DR6kwlbNUKKnzL/SKz2ZWfb9ML2EC5/zx8Ze5OId8G0=', 'Patient', 'Active', 'What\'s the name of your first pet?', '1ZTK7mu0xiIVQO4khZ9KJrB1cl9iwfprZz6eBnS2h3U=', 'patient_backiee-98927-landscape.jpg'),
(43, 'destinado', 'carlo', 'destinado@gmail.com', 'tibok', '0mdfhcTmiPpPz6rLm7TDzugR3GK+enovXRN3nDF+bAk=', 'Patient', 'Active', 'What\'s the name of your First pet?', 'aNnmAY2ohr/dfgLOh6WH7MXeGRME4REc2THUjNm8p0Y=', 'Null');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_diagnosis`
--
ALTER TABLE `tbl_diagnosis`
  ADD PRIMARY KEY (`d_id`);

--
-- Indexes for table `tbl_log`
--
ALTER TABLE `tbl_log`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `fk_log_user_id` (`u_id`);

--
-- Indexes for table `tbl_specialty`
--
ALTER TABLE `tbl_specialty`
  ADD PRIMARY KEY (`s_id`),
  ADD KEY `uid` (`u_id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_diagnosis`
--
ALTER TABLE `tbl_diagnosis`
  MODIFY `d_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_log`
--
ALTER TABLE `tbl_log`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=169;

--
-- AUTO_INCREMENT for table `tbl_specialty`
--
ALTER TABLE `tbl_specialty`
  MODIFY `s_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_log`
--
ALTER TABLE `tbl_log`
  ADD CONSTRAINT `fk_log_user_id` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_specialty`
--
ALTER TABLE `tbl_specialty`
  ADD CONSTRAINT `uid` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
