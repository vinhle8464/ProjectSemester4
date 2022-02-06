-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 31, 2022 at 09:50 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 7.4.21

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
  `status` bit(2) NOT NULL,
  `create_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`account_id`, `username`, `password`, `fullname`, `email`, `dob`, `addr`, `gender`, `phone`, `avatar`, `status`, `create_date`) VALUES
(98, 'admin', '$2a$10$cCcdzCmcV8gEdY5M1HfdJ.o2t4IS2NezqD9kZC0nAmQ52VIxTtcAu', 'Admin Nguyen', 'adminnguyen.123@gmail.com', '1995-01-01', 'Tp HCM', b'00', '0999999999', '7ae495b8454a4fa18ce205e45d19cc1f.jpg', b'01', '2022-01-31'),
(99, 'ngoctran', '$2a$10$cCcdzCmcV8gEdY5M1HfdJ.o2t4IS2NezqD9kZC0nAmQ52VIxTtcAu', 'Nguyen H Ngoc Tran', 'ngoctran.04012001@gmail.com', '2001-04-01', 'Tay Ninh', b'00', '0765716380', 'd817a1cee4314c58a141d5094be6a954.jpg', b'01', '2022-01-31'),
(100, 'faculty', '$2a$04$fRTvF4CbQsOyPVix5QE5TeaoQAc34OjQ/RYfcmEfDaQRDCVZL0spK', 'Faculty John', 'tranmini0401@gmail.com', '1992-01-01', 'Binh Duong', b'01', '0999123456', '6b751578e8ca40f2ac687be9fb6ebd85.jpg', b'01', '2022-01-31'),
(101, 'chuongnau', '$2a$10$V0/brp1iAprBWyXfTH9UQejZc64w//XYaKYGCUp273FtIzS01jsMm', 'Chu Ong Nau', 'lephat8464@gmail.com', '2001-06-14', 'Tay Ninh', b'01', '0942755402', 'bac2667253044015ad123d7aab6b63b3.jpg', b'01', '2022-01-31'),
(102, 'chiongngaongo', '$2a$10$V0/brp1iAprBWyXfTH9UQejZc64w//XYaKYGCUp273FtIzS01jsMm', 'Chi Ong Ngao Ngo', 'chiongngaongo@gmail.com', '2001-06-14', 'Tay Ninh', b'01', '0111111111', 'bac2667253044015ad123d7aab6b63b3.jpg', b'01', '2022-01-31'),
(103, 'chionglotomo', '$2a$10$V0/brp1iAprBWyXfTH9UQejZc64w//XYaKYGCUp273FtIzS01jsMm', 'Chi Ong Lo To Mo', 'chionglotomo@gmail.com', '2001-06-14', 'Tay Ninh', b'01', '0123456123', 'bac2667253044015ad123d7aab6b63b3.jpg', b'01', '2022-01-31'),
(104, 'chiongxanhle', '$2a$10$V0/brp1iAprBWyXfTH9UQejZc64w//XYaKYGCUp273FtIzS01jsMm', 'Chi Ong Xanh Le', 'chiongxanhle@gmail.com', '2001-06-14', 'Tay Ninh', b'00', '0888555222', 'bac2667253044015ad123d7aab6b63b3.jpg', b'01', '2022-01-31'),
(105, 'faculty2', '$2a$10$iOhJsUia8lMgO5gSV5wMuehX5rRng.WmptNr2gJfntrOubbvn0dPi', 'Faculty Marry', 'marry@gmail.com', '1993-01-07', 'Dong Nai', b'00', '0133156555', 'd008449ac37b4531a065b2a37911e568.jpg', b'01', '2022-01-31');

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
(98, 1),
(99, 3),
(100, 2),
(101, 3),
(102, 3),
(103, 3),
(104, 3),
(105, 2);

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
(108, 'has walked', 40, b'01', b'01'),
(109, 'was walking', 40, b'00', b'01'),
(110, 'walked', 40, b'00', b'01'),
(111, 'is walking', 40, b'00', b'01'),
(112, 'religious   ', 41, b'00', b'01'),
(113, 'performance   ', 41, b'00', b'01'),
(114, 'miserable    ', 41, b'01', b'01'),
(115, 'including   ', 41, b'00', b'01'),
(116, 'Science    ', 42, b'00', b'01'),
(117, 'Geography    ', 42, b'01', b'01'),
(118, 'History          ', 42, b'00', b'01'),
(119, 'Technology  ', 42, b'00', b'01'),
(120, 'put up ', 43, b'00', b'01'),
(121, 'put off   ', 43, b'00', b'01'),
(122, 'put out   ', 43, b'01', b'01'),
(123, 'put on', 43, b'00', b'01'),
(124, 'in order to', 44, b'00', b'01'),
(125, 'though ', 44, b'00', b'01'),
(126, 'so that', 44, b'01', b'01'),
(127, 'unless', 44, b'00', b'01'),
(128, '999999', 45, b'00', b'01'),
(129, '78388', 45, b'01', b'01'),
(130, '73288', 45, b'00', b'01'),
(131, '824566', 45, b'00', b'01'),
(132, '456131540', 46, b'00', b'01'),
(133, '454121155', 46, b'00', b'01'),
(134, '454345364', 46, b'00', b'01'),
(135, '695232192', 46, b'01', b'01'),
(136, '5', 47, b'00', b'01'),
(137, '3', 47, b'00', b'01'),
(138, '4', 47, b'00', b'01'),
(139, '6', 47, b'00', b'01'),
(140, '1000000000', 48, b'01', b'01'),
(141, '10000000000', 48, b'00', b'01'),
(142, '100000000000', 48, b'00', b'01'),
(143, '1000000000000', 48, b'00', b'01'),
(144, '20', 49, b'00', b'01'),
(145, '19', 49, b'00', b'01'),
(146, '22', 49, b'00', b'01'),
(147, '21', 49, b'01', b'01');

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
(8, 'Information technology', 'About information technology', b'01'),
(9, 'English', 'english', b'01');

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL,
  `comment` text NOT NULL,
  `account_id` int(11) NOT NULL,
  `quiz_id` int(11) NOT NULL,
  `status` bit(2) NOT NULL,
  `create_date` datetime NOT NULL
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
(4, 'Test', 'ngoctran.04012001@gmail.com', 'ngoc tran', '0911111111', 'Test duoc roi ne !!!', 'TEST LAN NUA NHA BAN IU', '2021-12-16 22:50:45', '2022-01-10 00:01:58', b'01', b'01'),
(5, 'alo', 'ngoctran.04012001@gmail.com', 'trantran', '0111111111', 'alo alo alo haa', NULL, '2021-12-16 23:06:12', NULL, b'00', b'00'),
(6, 'aaaa', 'ngoctran.04012001@gmail.com', 'aaaa', '90000000', 'hello alo ahaha', NULL, '2021-12-16 23:44:10', NULL, b'00', b'00'),
(7, 'abc', 'tran@gmail.com', 'tran', '0123456789', 'pla pla pla pla pla pla pla pla pla pla pla pla', NULL, '2022-01-31 15:19:55', NULL, b'00', b'00');

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
(1, 'Pack 1 month', 30, '0.99', 'You have 1 month to use the service', b'01'),
(2, 'Pack 3 months', 90, '2.99', 'You have 3 months to use the service', b'01'),
(3, 'Pack 1 year', 365, '11.99', 'You have 1 year to use the service', b'01'),
(6, 'Pack 2 years', 730, '23.99', 'You have 2 years use the service', b'01'),
(7, 'Pack 9 months', 270, '8.99', 'You have 9 months to use the service', b'01'),
(8, 'Pack 3 years', 1095, '35.99', 'You have 3 years use the service', b'01');

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
(40, 'When the old man____past the park, he saw some children playing football', 'explain pla pla pla', 14, b'01', 'radio'),
(41, 'Mark the letter A, B, C, or D on your answer sheet to indicate the word that differs from the other three in the position of the primary stress in each of the following questions. ', 'Câu C trọng âm 1, còn lại trọng âm 2.', 14, b'01', 'radio'),
(42, '_______ is the study of the Earth\'s physical features and the people, plants, and animals that live in different regions of the world.', 'Câu này dịch như sau: Địa lí là môn ngành nghiên cứu những sự vật vật lí trên Trái Đất và con người, cây cối, động vật sống ở những khu vực khác nhau trên Thế Giới. ', 14, b'01', 'radio'),
(43, 'As it was getting late, the boys decided to _______ the campfire and crept into their sleeping bags.', 'Câu này dịch là: Vì đã muộn rồi, những cậu con trai quyết định tắt lửa trại và chui vào túi ngủ của chúng', 14, b'01', 'radio'),
(44, 'The student took that course ______ he could improve his English.', 'Câu này dịch như sau: Cậu học sinh đã tham gia khóa học đó để anh ta có thể cải thiện khả năng tiếng Anh của anh ta. \r\nMệnh đề trước và mệnh đề sau mang nghĩa tương đồng => nối nhau bằng so that. \r\n', 14, b'01', 'radio'),
(45, '65842 + 12546  = ?', 'pla pla', 15, b'01', 'radio'),
(46, '1524632 * 456 = ?', 'pla pla', 15, b'01', 'radio'),
(47, '100 / 25', 'pla pla', 15, b'01', 'radio'),
(48, '123456789 + 876543211 = ?', 'pla pla ', 15, b'01', 'radio'),
(49, '2022 - 2001 = ?', 'pla pla', 15, b'01', 'radio');

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
(14, 'Test English 12', 'english 12', 100, 9, 0, 45, b'00', 'd151813aba814344a3d4c3a4079d9194.jfif', b'01', '2022-01-31 14:32:26'),
(15, 'Test Math 12', 'math 12', 100, 1, 0, 45, b'00', 'e86b97497bba4ac787efec1ffa0c3b74.jpg', b'01', '2022-01-31 15:04:14');

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE `rating` (
  `rating_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `quiz_id` int(11) NOT NULL,
  `star` int(11) NOT NULL,
  `created` datetime NOT NULL,
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
  `create_date` datetime NOT NULL,
  `status` bit(2) NOT NULL,
  `total_click_quiz` int(11) NOT NULL,
  `accept_payment` bit(2) NOT NULL,
  `total_click_quiz_month` int(11) NOT NULL
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
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`comment_id`),
  ADD KEY `account_id` (`account_id`),
  ADD KEY `quiz_id` (`quiz_id`);

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
-- Indexes for table `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`rating_id`),
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
  MODIFY `account_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=106;

--
-- AUTO_INCREMENT for table `account_pack`
--
ALTER TABLE `account_pack`
  MODIFY `account_pack_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `answer`
--
ALTER TABLE `answer`
  MODIFY `answer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=148;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `comment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `email`
--
ALTER TABLE `email`
  MODIFY `email_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `history_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `pack`
--
ALTER TABLE `pack`
  MODIFY `pack_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `pay`
--
ALTER TABLE `pay`
  MODIFY `pay_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `question_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT for table `quiz`
--
ALTER TABLE `quiz`
  MODIFY `quiz_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `rating`
--
ALTER TABLE `rating`
  MODIFY `rating_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `salary`
--
ALTER TABLE `salary`
  MODIFY `salary_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

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
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`quiz_id`);

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
-- Constraints for table `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `rating_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  ADD CONSTRAINT `rating_ibfk_2` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`quiz_id`);

--
-- Constraints for table `salary`
--
ALTER TABLE `salary`
  ADD CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
