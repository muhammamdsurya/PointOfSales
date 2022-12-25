-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 08, 2022 at 08:38 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pos`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `category` varchar(25) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `category`, `status`) VALUES
(9, 'Sayuran', 'Aktif'),
(10, 'Buah', 'Aktif'),
(11, 'Makanan', 'Aktif'),
(12, 'Narkoba', 'Aktif'),
(13, 'Minuan', 'Aktif');

-- --------------------------------------------------------

--
-- Table structure for table `kasir`
--

CREATE TABLE `kasir` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kasir`
--

INSERT INTO `kasir` (`id`, `username`, `password`, `status`) VALUES
(3, 'Surya', '123', 'Aktif');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `cat_id` varchar(50) NOT NULL,
  `harga` int(50) NOT NULL,
  `qty` int(100) NOT NULL,
  `barcode` int(50) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `nama`, `cat_id`, `harga`, `qty`, `barcode`, `status`) VALUES
(12, 'Wortel', 'Sayuran', 2000, 57, 1101, 'Aktif'),
(13, 'Pear', 'Buah', 5000, 144, 1102, 'Aktif'),
(14, 'Sosis', 'Makanan', 5000, 34, 1103, 'Aktif'),
(15, 'Ganja', 'Narkoba', 150000, 84, 1104, 'Aktif'),
(16, 'Susu Jahe', 'Minuan', 10000, 98, 1105, 'Aktif');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `id` int(11) NOT NULL,
  `date` varchar(255) NOT NULL,
  `kasir` varchar(255) NOT NULL,
  `total` int(100) NOT NULL,
  `bayar` int(100) NOT NULL,
  `balance` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`id`, `date`, `kasir`, `total`, `bayar`, `balance`) VALUES
(17, '2022/12/06', '', 24000, 50000, 26000),
(18, '2022/12/06', '', 8000, 100000, 92000),
(19, '2022/12/06', '', 6000, 70000, 64000),
(20, '2022/12/06', '', 12000, 70000, 58000),
(21, '2022/12/06', '', 4000, 5000, 1000),
(22, '2022/12/06', '', 4000, 5000, 1000),
(23, '2022/12/06', '', 14000, 5000, -9000),
(24, '2022/12/06', '', 81000, 100000, 19000),
(25, '2022/12/06', '', 20000, 50000, 30000),
(26, '2022/12/06', '', 6000, 7000, 1000),
(27, '2022/12/06', '', 4000, 5000, 1000),
(28, '2022/12/06', '', 19000, 50000, 31000),
(29, '2022/12/06', '', 19000, 20000, 1000),
(30, '2022/12/06', '', 26000, 30000, 4000),
(31, '2022/12/06', '', 24000, 30000, 6000),
(32, '2022/12/06', '', 24000, 30000, 6000),
(33, '2022/12/06', '', 26000, 30000, 4000),
(34, '2022/12/06', '', 621000, 10000000, 9379000),
(35, '2022/12/06', '', 24000, 30000, 6000),
(36, '2022/12/06', '', 19000, 20000, 1000),
(37, '2022/12/06', '', 19000, 20000, 1000),
(38, '2022/12/06', '', 24000, 25000, 1000),
(39, '2022/12/06', '', 19000, 20000, 1000),
(40, '2022/12/06', '', 24000, 50000, 26000),
(41, '2022/12/07', 'POS', 4000, 5000, 1000),
(42, '2022/12/07', 'Surya', 4000, 5000, 1000),
(43, '2022/12/07', 'Surya', 4000, 20000, 16000),
(44, '2022/12/07', 'Surya ', 320000, 500000, 180000);

-- --------------------------------------------------------

--
-- Table structure for table `sales_product`
--

CREATE TABLE `sales_product` (
  `id` int(11) NOT NULL,
  `sales_id` int(11) NOT NULL,
  `nama_id` int(255) NOT NULL,
  `harga` int(100) NOT NULL,
  `qty` int(100) NOT NULL,
  `subtotal` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sales_product`
--

INSERT INTO `sales_product` (`id`, `sales_id`, `nama_id`, `harga`, `qty`, `subtotal`) VALUES
(1, 17, 1102, 5000, 4, 20000),
(2, 17, 1102, 5000, 4, 20000),
(3, 20, 1101, 2000, 3, 6000),
(4, 20, 1101, 2000, 3, 6000),
(5, 24, 1102, 5000, 4, 20000),
(6, 24, 1102, 5000, 4, 20000),
(7, 24, 1102, 5000, 4, 20000),
(8, 24, 1102, 5000, 4, 20000),
(9, 27, 1101, 2000, 2, 4000),
(10, 28, 1101, 2000, 2, 4000),
(11, 28, 1102, 5000, 3, 15000),
(12, 29, 1101, 2000, 2, 4000),
(13, 29, 1102, 5000, 3, 15000),
(14, 30, 1101, 2000, 3, 6000),
(15, 30, 1102, 5000, 4, 20000),
(16, 31, 1101, 2000, 2, 4000),
(17, 31, 1102, 5000, 4, 20000),
(18, 32, 1101, 2000, 2, 4000),
(19, 32, 1103, 5000, 4, 20000),
(20, 33, 1101, 2000, 3, 6000),
(21, 33, 1102, 5000, 4, 20000),
(22, 34, 1101, 2000, 3, 6000),
(23, 34, 1102, 5000, 3, 15000),
(24, 34, 1104, 150000, 4, 600000),
(25, 35, 1101, 2000, 2, 4000),
(26, 35, 1102, 5000, 2, 10000),
(27, 35, 1103, 5000, 2, 10000),
(28, 36, 1101, 2000, 2, 4000),
(29, 36, 1102, 5000, 3, 15000),
(30, 37, 1101, 2000, 2, 4000),
(31, 37, 1102, 5000, 3, 15000),
(32, 38, 1101, 2000, 2, 4000),
(33, 38, 1102, 5000, 4, 20000),
(34, 39, 1101, 2000, 2, 4000),
(35, 39, 1102, 5000, 3, 15000),
(36, 40, 1101, 2000, 2, 4000),
(37, 40, 1102, 5000, 4, 20000),
(38, 41, 1101, 2000, 2, 4000),
(39, 42, 1101, 2000, 2, 4000),
(40, 43, 1101, 2000, 2, 4000),
(41, 44, 1105, 10000, 2, 20000),
(42, 44, 1104, 150000, 2, 300000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kasir`
--
ALTER TABLE `kasir`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sales_product`
--
ALTER TABLE `sales_product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `kasir`
--
ALTER TABLE `kasir`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `sales_product`
--
ALTER TABLE `sales_product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
