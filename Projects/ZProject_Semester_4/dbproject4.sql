-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 18, 2022 at 09:32 AM
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
(1, 'vinh', '$2a$10$msWcvnVP4KhL7HqtUq6ndOhDsC8iWiQUmPKXPeMhxHubJFLwvcO.W', 'vinh phat', 'lephat8464@gmail.com', '2021-12-08', 'asdfasf', b'01', '23423234', '4a20e5edeb464f5f864da72c5d2878f3.png', b'01'),
(2, 'user', '$2a$10$msWcvnVP4KhL7HqtUq6ndOhDsC8iWiQUmPKXPeMhxHubJFLwvcO.W', 'Faculty User', 'lephat8464@gmail.com', '2021-12-15', 'asdfasf', b'01', '234234234', '3c83adfb0bfe4c10bac147091d3888f3.png', b'01'),
(3, 'ngoctrantran', '$2a$10$msWcvnVP4KhL7HqtUq6ndOhDsC8iWiQUmPKXPeMhxHubJFLwvcO.W', 'Nguyen H Ngoc Tran', 'ngoctran.04012001@gmail.com', '2001-04-01', 'Tay Ninh', b'00', '0987654321', 'Photo28.jpg', b'01'),
(6, 'ngoctran', '$2a$10$msWcvnVP4KhL7HqtUq6ndOhDsC8iWiQUmPKXPeMhxHubJFLwvcO.W', 'Ngoc Tran', 'ngoctran@gmail.com', '2001-01-04', 'Tay Ninh', b'00', '0999123456', 'Photo24.jpg', b'01'),
(94, 'hehehe', '$2a$10$ECQuxj/7y.1yDH3Ix0pxKOAbZhAdpQy8WCZXpnmbj5kmgPAa9uI36', 'vinh', 'vinhkhung@gmail.com', '2021-12-01', 'tay ninh', b'01', '23423424', '822e27dd8557477486b79a78e35f4f3b.jpg', b'01'),
(95, 'usertran', '$2a$10$13/qJ3Yh7ChXLKcR1PZ4L.GrK4Iq3Tcb/3ZpJD1LdfCvhdGj0xQai', 'User Ngoc Tran', 'usertran@gmail.com', '2001-04-01', 'Tay Ninh', b'00', '0888123456', 'Photo24.jpg', b'01');

-- --------------------------------------------------------

--
-- Table structure for table `account_pack`
--

CREATE TABLE `account_pack` (
  `account_pack_id` int(11) NOT NULL,
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
(2, 2),
(3, 1),
(6, 2),
(95, 3);

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

--
-- Dumping data for table `answer`
--

INSERT INTO `answer` (`answer_id`, `title`, `question_id`, `answer_status`, `status`) VALUES
(2, 'Ngoc', 12, b'00', b'01'),
(3, 'Lan', 12, b'00', b'01'),
(4, 'Han', 12, b'00', b'01'),
(5, 'Tran', 12, b'01', b'01'),
(6, 'Sai gon', 13, b'00', b'01'),
(7, 'Da Nang', 13, b'00', b'01'),
(8, 'Tay Ninh', 13, b'01', b'01'),
(9, 'Ha Noi', 13, b'00', b'01'),
(10, 'Roi', 14, b'00', b'01'),
(11, 'Chua', 14, b'00', b'01'),
(12, 'Khong muon an com', 14, b'00', b'01'),
(13, 'Dang giam can k an com dau', 14, b'01', b'01'),
(14, '1m70', 15, b'00', b'01'),
(15, '1m50', 15, b'01', b'01'),
(16, '1m52', 15, b'00', b'01'),
(17, '1m48', 15, b'00', b'01'),
(18, '.btn_submit {\n    margin: auto;\n    text-align: center;\n    padding: 50px;\n}\n\n.btn_submit input {\n    color: white;\n    background-color: #eea412;\n    width: 200px;\n    font-size: 20px;\n    /* text-align: center; */\n    /* margin: auto; */\n.btn_submit {\n    margin: auto;\n    text-align: center;\n    padding: 50px;\n}\n\n.btn_submit input {\n    color: white;\n    background-color: #eea412;\n    width: 200px;\n    font-size: 20px;\n    /* text-align: center; */\n    /* margin: auto; */\n}', 16, b'00', b'01'),
(19, '.btn_submit {\n    margin: auto;\n    text-align: center;\n    padding: 50px;\n}\n\n.btn_submit input {\n    color: white;\n    background-color: #eea412;\n    width: 200px;\n    font-size: 20px;\n    /* text-align: center; */\n    /* margin: auto; */\n}', 16, b'00', b'01'),
(20, '.btn_submit {\n    margin: auto;\n    text-align: center;\n    padding: 50px;\n}\n\n.btn_submit input {\n    color: white;\n    background-color: #eea412;\n    width: 200px;\n    font-size: 20px;\n    /* text-align: center; */\n    /* margin: auto; */\n}', 16, b'01', b'01'),
(21, '3', 16, b'00', b'01'),
(22, '.btn_submit {\n    margin: auto;\n    text-align: center;\n    padding: 50px;\n}\n\n.btn_submit input {\n    color: white;\n    background-color: #eea412;\n    width: 200px;\n    font-size: 20px;\n    /* text-align: center; */\n    /* margin: auto; */\n}', 16, b'00', b'01'),
(23, '15', 17, b'00', b'01'),
(24, '21', 17, b'01', b'01'),
(25, '.btn_submit {\n    margin: auto;\n    text-align: center;\n    padding: 50px;\n}\n\n.btn_submit input {\n    color: white;\n    background-color: #eea412;\n    width: 200px;\n    font-size: 20px;\n    /* text-align: center; */\n    /* margin: auto; */\n}', 17, b'00', b'01'),
(26, '12', 17, b'00', b'01'),
(27, '18', 17, b'00', b'01'),
(28, '1', 18, b'00', b'01'),
(29, '2', 18, b'00', b'01'),
(30, '3', 18, b'01', b'01'),
(31, '1', 19, b'00', b'01'),
(32, '2', 19, b'00', b'01'),
(33, '3', 19, b'00', b'01'),
(34, '4', 19, b'01', b'01'),
(35, '5', 19, b'01', b'01'),
(36, 'vui', 20, b'01', b'01'),
(37, 'buon', 20, b'00', b'01'),
(38, 'kkhoc', 20, b'00', b'01'),
(39, 'xiu', 20, b'00', b'01'),
(40, '1', 21, b'01', b'01'),
(41, '2', 21, b'00', b'01'),
(42, '3', 21, b'00', b'01'),
(43, '1 chan', 22, b'01', b'01'),
(44, '2 chan', 22, b'00', b'01'),
(45, '3 chan', 22, b'01', b'01'),
(46, '4 chan', 22, b'00', b'01'),
(48, 'asdf', 23, b'01', b'01'),
(49, 'fdsa', 23, b'00', b'01'),
(50, 'vvvvvv', 23, b'00', b'01'),
(51, 'qqqq', 24, b'01', b'01'),
(52, 'wwww', 24, b'00', b'01'),
(53, 'eeeee', 24, b'00', b'01'),
(54, 'rrrrrr', 24, b'01', b'01'),
(55, 'rrrr', 25, b'00', b'01'),
(56, 'eeee', 25, b'01', b'01'),
(57, 'wwwww', 25, b'00', b'01'),
(58, 'qqqqqq', 25, b'01', b'01'),
(60, 'sdf', 24, b'00', b'01'),
(61, 'rrer', 24, b'00', b'01'),
(62, 'gggeeee', 24, b'01', b'01'),
(63, 'sdSDF', 28, b'01', b'01'),
(64, 'sdf', 28, b'01', b'01'),
(65, 'SADF', 28, b'00', b'01'),
(66, 'sdf', 31, b'00', b'01'),
(67, 'sdf', 31, b'01', b'01'),
(68, 'sdf', 31, b'00', b'01'),
(69, 'sdf', 32, b'01', b'01'),
(70, 'sdf', 32, b'00', b'01'),
(71, 'sdf', 32, b'01', b'01'),
(72, 'new', 33, b'00', b'01'),
(73, 'sdf', 33, b'01', b'01'),
(74, 'new', 33, b'00', b'01');

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

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `title`, `description`, `status`) VALUES
(1, 'Math', 'Test Math', b'01'),
(2, 'Physic', 'Test Physic', b'01'),
(3, 'Chemistry', 'Test chemistry', b'00'),
(4, 'Biological', 'About biological', b'01'),
(5, 'Literature', 'About literature', b'01'),
(6, 'Geographic', 'About geographic', b'01'),
(7, 'Technology', 'About technology', b'01'),
(8, 'Information technology', 'About information technology', b'01');

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
(4, 'Test', 'ngoctran.04012001@gmail.com', 'ngoc tran', '0911111111', 'Test duoc roi ne !!!', 'TEST LAN NUA NHA BAN IU', '2021-12-16 22:50:45', '2022-01-10 00:01:58', b'01', b'01'),
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
  `status` bit(2) NOT NULL,
  `list_question_id` text NOT NULL,
  `list_answer_choice` text NOT NULL,
  `time_done` int(11) NOT NULL,
  `number_right_answer` int(11) NOT NULL
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

--
-- Dumping data for table `pack`
--

INSERT INTO `pack` (`pack_id`, `title`, `expiry`, `fee`, `description`, `status`) VALUES
(1, 'Pack 1 month', 30, '5.32', 'You have 1 month to use the service', b'01'),
(2, 'Pack 3 months', 90, '13.23', 'You have 3 months to use the service', b'01'),
(3, 'Pack 1 year', 365, '49.00', 'You have 1 year to use the service', b'01'),
(5, 'Pack 1 day', 1, '1.00', 'You have 1 day to use the service', b'01'),
(6, 'Pack 2 years', 730, '95.00', 'You have 2 years use the service', b'01');

-- --------------------------------------------------------

--
-- Table structure for table `pay`
--

CREATE TABLE `pay` (
  `pay_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `payment` varchar(100) NOT NULL,
  `title` varchar(250) NOT NULL,
  `fee` decimal(10,2) NOT NULL,
  `date_paid` datetime NOT NULL,
  `pay_status` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pay`
--

INSERT INTO `pay` (`pay_id`, `account_id`, `payment`, `title`, `fee`, `date_paid`, `pay_status`) VALUES
(1, 2, 'cash', 'oke con de', '120.43', '2021-12-10 22:36:39', b'01'),
(2, 2, 'credit card', 'asdfsda', '200.23', '2021-12-12 16:37:30', b'01'),
(3, 2, 'credit card', 'hhhhh', '2000.43', '2021-12-12 16:37:30', b'01'),
(4, 3, 'card', 'fee', '15.23', '2021-12-16 20:32:56', b'01'),
(5, 3, 'card', '0.52', '15.00', '2021-12-16 20:39:23', b'01'),
(6, 3, 'card', '0.52', '15.00', '2021-12-16 23:44:54', b'01'),
(7, 95, 'PAYPAL', 'PAYMENT PACK', '10.00', '2022-01-04 14:59:25', b'01'),
(8, 95, 'PAYPAL', 'PAYMENT PACK', '10.00', '2022-01-04 15:00:05', b'01'),
(9, 95, 'PAYPAL', 'PAYMENT PACK', '10.00', '2022-01-04 15:09:25', b'01'),
(10, 1, 'PAYPAL', 'PAYMENT PACK', '11.00', '2022-01-06 20:59:15', b'01'),
(11, 1, 'PAYPAL', 'PAYMENT PACK', '11.00', '2022-01-06 21:09:17', b'01'),
(12, 1, 'PAYPAL', 'PAYMENT PACK', '11.00', '2022-01-06 21:10:44', b'01'),
(13, 6, 'PAYPAL', 'PAYMENT PACK - CODE: 6US04340G0361683A', '1.00', '2022-01-08 16:00:13', b'01');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `question_id` int(11) NOT NULL,
  `title` varchar(250) NOT NULL,
  `explain_detail` text NOT NULL,
  `quiz_id` int(11) NOT NULL,
  `status` bit(2) NOT NULL,
  `type_answer_choice` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`question_id`, `title`, `explain_detail`, `quiz_id`, `status`, `type_answer_choice`) VALUES
(12, 'cau hoi 1: em ten gi', 'hehe', 12, b'01', 'checkbox'),
(13, 'cau hoi 2: em nha o dau the', 'keke', 12, b'01', 'checkbox'),
(14, 'cau hoi 3: em an com chua', 'hihi', 12, b'01', 'checkbox'),
(15, 'cau hoi 4: em cao bn the', 'hoho', 12, b'01', 'checkbox'),
(16, 'cau hoi 5: humm em la con thu may trong gia dinh ay nhi', 'huhu', 12, b'01', 'checkbox'),
(17, 'cau hoi 6: em bao nhieu tuoi roii', 'hic', 12, b'01', 'checkbox'),
(18, 'cau hoi 7 sai het roi ', 'nhieu data qua', 12, b'01', 'checkbox'),
(19, 'cau 8 test lan cuoi', 'huhu ra di ', 12, b'01', 'checkbox'),
(20, 'cau 9: thanh cong rui', 'vui qua di', 12, b'01', 'checkbox'),
(21, 'tset', 'test', 11, b'01', 'checkbox'),
(22, 'con co co may chan', 'giagi thich', 13, b'01', 'checkbox'),
(23, 'aaaa', 'bbbb', 13, b'01', 'checkbox'),
(24, 'abcbcbc', 'assssss', 13, b'01', 'checkbox'),
(25, 'ggggg', 'tt', 13, b'01', 'checkbox'),
(28, 'SDF', 'SDF', 13, b'01', 'checkbox'),
(31, 'con cho', 'asdf', 13, b'01', 'radio'),
(32, 'alibab', 'asdf', 13, b'01', 'checkbox'),
(33, 'sdf', 'sdf', 13, b'01', 'radio');

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
  `image` text NOT NULL,
  `status` bit(2) NOT NULL,
  `date_created` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `quiz`
--

INSERT INTO `quiz` (`quiz_id`, `title`, `description`, `account_id`, `category_id`, `times`, `timer`, `fee`, `image`, `status`, `date_created`) VALUES
(1, '50 câu trắc nghiệm cơ bản về tích phân 12', 'trắc nghiêhm tích phân 12', 2, 1, 12, 60, b'00', 'Photo24.jpg', b'01', '2021-12-08 21:11:07'),
(2, '45 cau trac nghiem nang cao mon vat ly', 'Vat Li', 6, 2, 0, 60, b'00', 'Photo24.jpg', b'01', '2021-12-08 21:11:21'),
(3, 'trắc nghiệm về văn học', 'trắc nghiệm văn học', 2, 5, 0, 45, b'01', 'Photo24.jpg', b'01', '2021-12-08 21:11:14'),
(5, 'Trắc nghiệm về vật lí', 'trắc nghiệm vật lí', 2, 2, 0, 45, b'00', 'Photo24.jpg', b'01', '2021-12-08 21:11:16'),
(6, 'trắc nghiệm về .NET', 'trắc nghiệm .NET', 2, 8, 0, 60, b'01', 'Photo24.jpg', b'01', '2021-12-08 21:11:09'),
(7, 'trắc nghiệm về địa lí 12', 'trắc nghiệm địa lí\r\nde et ha', 2, 6, 44, 50, b'00', 'Photo24.jpg', b'00', '2021-12-08 21:11:19'),
(8, '50 câu trắc nghiệm về phenol', 'trắc nghiệm hóa học', 2, 3, 0, 60, b'00', 'Photo24.jpg', b'01', '2021-12-08 21:11:11'),
(9, 'trắc nghiệm về môn sinh 12', 'tắc nghiệm sinh học', 2, 4, 0, 50, b'00', 'Photo24.jpg', b'00', '2021-12-08 21:11:01'),
(10, 'ABC', 'TEST ABC', 6, 5, 0, 45, b'00', 'Photo24.jpg', b'01', '2021-12-08 21:11:04'),
(11, 'trac nghiem tinh cach trac nghiem tinh cachtrac nghiem tinh cachtrac nghiem tinh cach trac nghiem tinh cachtrac nghiem tinh cach', 'xa\nde ec \nkhong co j het\n khong kho\nde ec \nkhong co j het\nkhong kho\nde ec \nkhong co j het\nkhong kho\nde ec \nkhong co j het\nkhong kho\nde ec \nkhong co j het\nkhong kho\nde ec \nkhong co j het\nkhong kho\nde ec \nkhong co j het\nkhong kho\nde ec \nkhong co j het\nkhong kho\nde ec \nkhong co j het\nkhong kho\nde ec \nkhong co j hj het\n', 2, 8, 11, 10, b'00', '4a20e5edeb464f5f864da72c5d2878f3.png', b'01', '2021-12-08 21:11:24'),
(12, 'CAU HOI TRAC NGHIEM VE CO BE NAO DO', 'khong kho\r\nde ec \r\nkhong co j het\r\n', 2, 8, 136, 1, b'01', 'Photo24.jpg', b'01', '2021-12-08 21:10:55'),
(13, 'Trac nghiem online', 'mo ta', 2, 8, 0, 30, b'00', 'd4b401c35b514e0a804875b1f32e5f9f.png', b'01', '2022-01-17 07:35:55');

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
(2, 'ROLE_USER_FACULTY', 'role user faculty', b'01'),
(3, 'ROLE_USER_CANDIDATE', 'role user candidate\r\n', b'01');

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
  ADD PRIMARY KEY (`account_pack_id`),
  ADD KEY `account_id` (`account_id`),
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
  ADD PRIMARY KEY (`history_id`),
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
  MODIFY `account_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=96;

--
-- AUTO_INCREMENT for table `account_pack`
--
ALTER TABLE `account_pack`
  MODIFY `account_pack_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `answer`
--
ALTER TABLE `answer`
  MODIFY `answer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `email`
--
ALTER TABLE `email`
  MODIFY `email_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `history_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pack`
--
ALTER TABLE `pack`
  MODIFY `pack_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `pay`
--
ALTER TABLE `pay`
  MODIFY `pay_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `question_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `quiz`
--
ALTER TABLE `quiz`
  MODIFY `quiz_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `rating_comment`
--
ALTER TABLE `rating_comment`
  MODIFY `rating_comment_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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
