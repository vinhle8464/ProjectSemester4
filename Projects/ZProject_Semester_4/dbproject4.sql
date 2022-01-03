-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 03, 2022 at 04:34 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbproject4`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `account_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(250) NOT NULL,
  `fullname` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `dob` date DEFAULT NULL,
  `addr` varchar(250) NOT NULL,
  `gender` bit(2) NOT NULL,
  `phone` varchar(250) DEFAULT NULL,
  `avatar` text NOT NULL,
  `status` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`account_id`, `username`, `password`, `fullname`, `email`, `dob`, `addr`, `gender`, `phone`, `avatar`, `status`) VALUES
(1, 'vinh', '$2a$10$WSrS1Cs.u7W.iCtPAZgJr.hd6BkBG.Iz6pIcKeKDlZD1POTF04bMO', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', '148fa5fab32d4e669482caa8943cfd38.jpg', b'01'),
(2, 'user', '$2a$10$WSrS1Cs.u7W.iCtPAZgJr.hd6BkBG.Iz6pIcKeKDlZD1POTF04bMO', 'asdfasdf', 'asdfasdf', '2021-12-15', 'asdfasf', b'01', '234234234', '148fa5fab32d4e669482caa8943cfd38.jpg', b'01'),
(3, 'ngoctrantran', '$2a$10$msWcvnVP4KhL7HqtUq6ndOhDsC8iWiQUmPKXPeMhxHubJFLwvcO.W', 'Nguyen Hoang Ngoc Tran', 'ngoctran.04012001@gmail.com', '2001-04-01', 'Hoa Thanh, Tay Ninh', b'00', '0987654321', '148fa5fab32d4e669482caa8943cfd38.jpg', b'01'),
(6, 'ngoctran', '$2a$10$ceQX2Vq.3igdk4e7dprqvuRhPq9JRXk9YU1i2U6ubQrFSSR2dRrSC', 'Ngoc Tran', 'ngoctran@gmail.com', '2001-01-04', 'Tay Ninh', b'00', '0999123456', '148fa5fab32d4e669482caa8943cfd38.jpg', b'01'),
(7, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(8, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(9, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(10, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(11, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(12, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(13, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(14, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(15, 'asdf', '1', 'asdfasdf', 'asdfasdf', '2021-12-15', 'asdfasf', b'01', '234234234', 'asdfasdf', b'01'),
(16, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(17, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(18, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(19, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(20, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(21, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(22, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(23, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(24, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(25, 'asdf', '1', 'asdfasdf', 'asdfasdf', '2021-12-15', 'asdfasf', b'01', '234234234', 'asdfasdf', b'01'),
(26, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(27, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(96, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(97, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(98, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(99, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(100, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(101, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(102, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(103, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(104, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(105, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(106, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(107, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(108, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(109, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(110, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01'),
(111, 'asdf', '1', 'vinh phat', 'lephatlksjdf', '2021-12-08', 'asdfasf', b'01', '23423234', 'asdfasdf', b'01');

-- --------------------------------------------------------

--
-- Table structure for table `account_pack`
--

CREATE TABLE `account_pack` (
  `account_id` int(11) NOT NULL,
  `pack_id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `status` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `account_role`
--

CREATE TABLE `account_role` (
  `account_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account_role`
--

INSERT INTO `account_role` (`account_id`, `role_id`) VALUES
(1, 1),
(1, 2),
(3, 1),
(6, 1);

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE `answer` (
  `answer_id` int(11) NOT NULL,
  `title` text NOT NULL,
  `question_id` int(11) NOT NULL,
  `answer_status` bit(2) NOT NULL,
  `status` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `title` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `status` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `email`
--

CREATE TABLE `email` (
  `email_id` int(11) NOT NULL,
  `title` varchar(250) NOT NULL,
  `email_user` varchar(100) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `content` text NOT NULL,
  `reply_content` text DEFAULT NULL,
  `send_date` datetime NOT NULL,
  `reply_date` datetime DEFAULT NULL,
  `checked` bit(2) NOT NULL,
  `status` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `email`
--

INSERT INTO `email` (`email_id`, `title`, `email_user`, `fullname`, `phone_number`, `content`, `reply_content`, `send_date`, `reply_date`, `checked`, `status`) VALUES
(1, 'con khi', 'useremail@lkadjf', 'ten user', '234234234', 'help me', NULL, '2021-12-12 16:38:12', NULL, b'00', b'01'),
(2, 'con meo', 'useremail@lkadjf', 'ten user', '234234234', 'help me', NULL, '2021-12-12 16:38:12', NULL, b'00', b'01'),
(3, 'hhhh', 'hhh@gmail.com', 'hhhhhh', '000000000', 'hhahahahahahahahahahahaha', NULL, '2021-12-13 20:55:02', NULL, b'00', b'00'),
(4, 'Test', 'ngoctran.04012001@gmail.com', 'ngoc tran', '0911111111', 'Test duoc roi ne !!!', NULL, '2021-12-16 22:50:45', NULL, b'00', b'00'),
(5, 'alo', 'ngoctran.04012001@gmail.com', 'trantran', '0111111111', 'alo alo alo haa', NULL, '2021-12-16 23:06:12', NULL, b'00', b'00'),
(6, 'aaaa', 'ngoctran.04012001@gmail.com', 'aaaa', '90000000', 'hello alo ahaha', NULL, '2021-12-16 23:44:10', NULL, b'00', b'00');

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `history_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `quiz_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `status` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pack`
--

CREATE TABLE `pack` (
  `pack_id` int(11) NOT NULL,
  `title` varchar(300) NOT NULL,
  `expiry` int(11) NOT NULL,
  `fee` decimal(10,2) NOT NULL,
  `description` text NOT NULL,
  `status` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pay`
--

CREATE TABLE `pay` (
  `pay_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `payment` varchar(100) NOT NULL,
  `title` varchar(250) NOT NULL,
  `fee` decimal(10,0) NOT NULL,
  `date_paid` datetime NOT NULL,
  `pay_status` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pay`
--

INSERT INTO `pay` (`pay_id`, `account_id`, `payment`, `title`, `fee`, `date_paid`, `pay_status`) VALUES
(1, 2, 'cash', 'oke con de', '120', '2021-12-10 22:36:39', b'01'),
(2, 2, 'credit card', 'asdfsda', '200', '2021-12-12 16:37:30', b'01'),
(3, 2, 'credit card', 'hhhhh', '2000', '2021-12-12 16:37:30', b'01'),
(4, 3, 'card', 'fee', '15', '2021-12-16 20:32:56', b'01'),
(5, 3, 'card', '0.52', '15', '2021-12-16 20:39:23', b'01'),
(6, 3, 'card', '0.52', '15', '2021-12-16 23:44:54', b'01');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `question_id` int(11) NOT NULL,
  `title` varchar(250) NOT NULL,
  `explain` text NOT NULL,
  `quiz_id` int(11) NOT NULL,
  `status` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `quiz`
--

CREATE TABLE `quiz` (
  `quiz_id` int(11) NOT NULL,
  `title` varchar(250) NOT NULL,
  `description` text NOT NULL,
  `account_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `times` int(11) NOT NULL,
  `timer` tinyint(4) NOT NULL,
  `fee` bit(2) NOT NULL,
  `status` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `rating_comment`
--

CREATE TABLE `rating_comment` (
  `rating_comment_id` int(11) NOT NULL,
  `star` tinyint(4) NOT NULL,
  `comment` text NOT NULL,
  `account_id` int(11) NOT NULL,
  `quiz_id` int(11) NOT NULL,
  `status` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `status` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role_name`, `description`, `status`) VALUES
(1, 'ROLE_ADMIN', 'role admin', b'01'),
(2, 'ROLE_USER', 'role user', b'01');

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `salary_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `salary` decimal(10,2) NOT NULL,
  `date` date NOT NULL,
  `status` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`account_id`);

--
-- Indexes for table `account_pack`
--
ALTER TABLE `account_pack`
  ADD PRIMARY KEY (`account_id`,`pack_id`),
  ADD KEY `pack_id` (`pack_id`);

--
-- Indexes for table `account_role`
--
ALTER TABLE `account_role`
  ADD PRIMARY KEY (`account_id`,`role_id`),
  ADD KEY `ac_role_pk_2` (`role_id`);

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`answer_id`),
  ADD KEY `question_id` (`question_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `email`
--
ALTER TABLE `email`
  ADD PRIMARY KEY (`email_id`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD KEY `account_id` (`account_id`),
  ADD KEY `quiz_id` (`quiz_id`);

--
-- Indexes for table `pack`
--
ALTER TABLE `pack`
  ADD PRIMARY KEY (`pack_id`);

--
-- Indexes for table `pay`
--
ALTER TABLE `pay`
  ADD PRIMARY KEY (`pay_id`),
  ADD KEY `FK_pay_account` (`account_id`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`question_id`),
  ADD KEY `quiz_id` (`quiz_id`);

--
-- Indexes for table `quiz`
--
ALTER TABLE `quiz`
  ADD PRIMARY KEY (`quiz_id`),
  ADD KEY `account_id` (`account_id`),
  ADD KEY `category_id` (`category_id`);

--
-- Indexes for table `rating_comment`
--
ALTER TABLE `rating_comment`
  ADD PRIMARY KEY (`rating_comment_id`),
  ADD KEY `account_id` (`account_id`),
  ADD KEY `quiz_id` (`quiz_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`salary_id`),
  ADD KEY `account_id` (`account_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `account_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- AUTO_INCREMENT for table `answer`
--
ALTER TABLE `answer`
  MODIFY `answer_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `email`
--
ALTER TABLE `email`
  MODIFY `email_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `pack`
--
ALTER TABLE `pack`
  MODIFY `pack_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pay`
--
ALTER TABLE `pay`
  MODIFY `pay_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `question_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `quiz`
--
ALTER TABLE `quiz`
  MODIFY `quiz_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rating_comment`
--
ALTER TABLE `rating_comment`
  MODIFY `rating_comment_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `salary`
--
ALTER TABLE `salary`
  MODIFY `salary_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account_pack`
--
ALTER TABLE `account_pack`
  ADD CONSTRAINT `account_pack_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  ADD CONSTRAINT `account_pack_ibfk_2` FOREIGN KEY (`pack_id`) REFERENCES `pack` (`pack_id`);

--
-- Constraints for table `account_role`
--
ALTER TABLE `account_role`
  ADD CONSTRAINT `ac_role_pk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  ADD CONSTRAINT `ac_role_pk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);

--
-- Constraints for table `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`);

--
-- Constraints for table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  ADD CONSTRAINT `history_ibfk_2` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`quiz_id`);

--
-- Constraints for table `pay`
--
ALTER TABLE `pay`
  ADD CONSTRAINT `FK_pay_account` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`);

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`quiz_id`);

--
-- Constraints for table `quiz`
--
ALTER TABLE `quiz`
  ADD CONSTRAINT `quiz_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  ADD CONSTRAINT `quiz_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`);

--
-- Constraints for table `rating_comment`
--
ALTER TABLE `rating_comment`
  ADD CONSTRAINT `rating_comment_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  ADD CONSTRAINT `rating_comment_ibfk_2` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`quiz_id`);

--
-- Constraints for table `salary`
--
ALTER TABLE `salary`
  ADD CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
