-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 26, 2018 at 06:31 AM
-- Server version: 5.6.38
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `cads_v1`
--

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE IF NOT EXISTS TABLE `city` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`id`, `name`) VALUES
(1, 'Bengaluru'),
(2, 'Chennai'),
(4, 'Delhi'),
(5, 'Kolkata'),
(3, 'Mumbai');

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE IF NOT EXISTS TABLE `country` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`id`, `name`) VALUES
(1, 'India');

-- --------------------------------------------------------

--
-- Table structure for table `group_info`
--

CREATE IF NOT EXISTS TABLE `group_info` (
  `id` int(11) NOT NULL,
  `name` varchar(15) NOT NULL,
  `description` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `group_user`
--

CREATE IF NOT EXISTS TABLE `group_user` (
  `id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `house`
--

CREATE IF NOT EXISTS TABLE `house` (
  `id` int(11) NOT NULL,
  `number` varchar(10) NOT NULL,
  `size` int(11) DEFAULT NULL COMMENT 'square feet',
  `maintenance_amount` decimal(10,0) DEFAULT NULL,
  `is_vacant` tinyint(1) DEFAULT NULL,
  `parking_number1` varchar(10) DEFAULT NULL COMMENT 'first parking',
  `parking_number2` varchar(10) DEFAULT NULL COMMENT 'second parking',
  `parking_number3` varchar(10) DEFAULT NULL COMMENT 'third (last) parking',
  `house_type` enum('STUDIO','1BHK','2BHK','3BHK','4BHK','NBHK','VILLA','CUSTOM') DEFAULT NULL,
  `house_description` varchar(50) DEFAULT NULL COMMENT 'extra info about house'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `property`
--

CREATE IF NOT EXISTS TABLE `property` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `addressLine1` varchar(40) NOT NULL,
  `addressLine2` varchar(40) DEFAULT NULL,
  `pin` varchar(20) NOT NULL,
  `locality` varchar(20) DEFAULT NULL,
  `city` int(11) NOT NULL,
  `country` int(11) NOT NULL,
  `completed` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `property_user`
--

CREATE IF NOT EXISTS TABLE `property_user` (
  `id` int(11) NOT NULL,
  `property_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `house_id` int(11) DEFAULT NULL,
  `occupant_type` enum('OWNER','TENANT','BUILDER','') NOT NULL,
  `occupation_start_date` date DEFAULT NULL,
  `occupation_end_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE IF NOT EXISTS TABLE `user` (
  `id` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `lastLogin` datetime DEFAULT NULL,
  `email` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user_password`
--

CREATE IF NOT EXISTS TABLE `user_password` (
  `user_id` varchar(50) NOT NULL,
  `user_pass` varchar(20) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `group_info`
--
ALTER TABLE `group_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `group_user`
--
ALTER TABLE `group_user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `group` (`group_id`),
  ADD KEY `user` (`user_id`);

--
-- Indexes for table `house`
--
ALTER TABLE `house`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `property`
--
ALTER TABLE `property`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `pin` (`pin`),
  ADD KEY `country` (`country`),
  ADD KEY `city` (`city`);

--
-- Indexes for table `property_user`
--
ALTER TABLE `property_user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_key` (`user_id`),
  ADD KEY `property_key` (`property_id`),
  ADD KEY `house_key` (`house_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `user_password`
--
ALTER TABLE `user_password`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `group_info`
--
ALTER TABLE `group_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `house`
--
ALTER TABLE `house`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `property`
--
ALTER TABLE `property`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `property_user`
--
ALTER TABLE `property_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user_password`
--
ALTER TABLE `user_password`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `group_user`
--
ALTER TABLE `group_user`
  ADD CONSTRAINT `group` FOREIGN KEY (`group_id`) REFERENCES `group_info` (`id`),
  ADD CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `property`
--
ALTER TABLE `property`
  ADD CONSTRAINT `city` FOREIGN KEY (`city`) REFERENCES `city` (`id`),
  ADD CONSTRAINT `country` FOREIGN KEY (`country`) REFERENCES `country` (`id`);

--
-- Constraints for table `property_user`
--
ALTER TABLE `property_user`
  ADD CONSTRAINT `house_key` FOREIGN KEY (`house_id`) REFERENCES `house` (`id`),
  ADD CONSTRAINT `property_key` FOREIGN KEY (`property_id`) REFERENCES `property` (`id`),
  ADD CONSTRAINT `user_key` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `user_password`
--
ALTER TABLE `user_password`
  ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
