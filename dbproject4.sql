-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th12 06, 2021 lúc 04:38 PM
-- Phiên bản máy phục vụ: 10.4.20-MariaDB
-- Phiên bản PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dbproject4`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `account_id` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(250) NOT NULL,
  `fullname` varchar(100) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `dob` date DEFAULT NULL,
  `addr` varchar(250) DEFAULT NULL,
  `gender` bit(2) DEFAULT NULL,
  `phone` char(20) DEFAULT NULL,
  `avatar` text NOT NULL,
  `status` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`account_id`, `username`, `password`, `fullname`, `email`, `dob`, `addr`, `gender`, `phone`, `avatar`, `status`) VALUES
('acc1', 'vinh', '1', 'vinh', 'llasdfj', NULL, NULL, b'01', NULL, 'asdf', b'01');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account_role`
--

CREATE TABLE `account_role` (
  `account_id` varchar(50) NOT NULL,
  `role_id` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `account_role`
--

INSERT INTO `account_role` (`account_id`, `role_id`) VALUES
('acc1', 'admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mail`
--

CREATE TABLE `mail` (
  `mail_id` int(11) NOT NULL,
  `title` varchar(250) NOT NULL,
  `email_user` varchar(100) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `content` text NOT NULL,
  `reply_content` text NOT NULL,
  `send_date` datetime NOT NULL,
  `reply_date` datetime NOT NULL,
  `checked` bit(2) NOT NULL,
  `status` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pay`
--

CREATE TABLE `pay` (
  `pay_id` int(11) NOT NULL,
  `account_id` varchar(50) NOT NULL,
  `payment` varchar(100) NOT NULL,
  `title` varchar(250) NOT NULL,
  `fee` decimal(10,0) NOT NULL,
  `date_paid` datetime NOT NULL,
  `pay_status` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `role_id` varchar(50) NOT NULL,
  `role_name` varchar(100) NOT NULL,
  `description` varchar(250) NOT NULL,
  `status` bit(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`role_id`, `role_name`, `description`, `status`) VALUES
('admin', 'ROLE_ADMIN', 'Can do everything', b'01'),
('user', 'ROLE_USER', 'Having user\'s role', b'00');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`account_id`);

--
-- Chỉ mục cho bảng `account_role`
--
ALTER TABLE `account_role`
  ADD PRIMARY KEY (`account_id`,`role_id`),
  ADD KEY `ac_role_pk_2` (`role_id`);

--
-- Chỉ mục cho bảng `mail`
--
ALTER TABLE `mail`
  ADD PRIMARY KEY (`mail_id`);

--
-- Chỉ mục cho bảng `pay`
--
ALTER TABLE `pay`
  ADD PRIMARY KEY (`pay_id`),
  ADD KEY `FK_pay_account` (`account_id`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `mail`
--
ALTER TABLE `mail`
  MODIFY `mail_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `pay`
--
ALTER TABLE `pay`
  MODIFY `pay_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `account_role`
--
ALTER TABLE `account_role`
  ADD CONSTRAINT `ac_role_pk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  ADD CONSTRAINT `ac_role_pk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);

--
-- Các ràng buộc cho bảng `pay`
--
ALTER TABLE `pay`
  ADD CONSTRAINT `FK_pay_account` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
