-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 14, 2020 at 12:57 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ltm`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(3) NOT NULL,
  `name` varchar(40) NOT NULL,
  `author` varchar(40) NOT NULL,
  `total` int(3) NOT NULL,
  `remain` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `name`, `author`, `total`, `remain`) VALUES
(1, 'Thơ buồn', 'Xuân Diệu', 32, 11),
(2, 'Lá', 'Tố Hữu', 12, 3),
(3, 'Hoàng hôn buông xuống', 'Hồ Xuân Hương', 25, 27),
(4, 'Bé ba béo bở bắn bể bụng', 'Dân gian', 100, 3);

-- --------------------------------------------------------

--
-- Table structure for table `mathang`
--

CREATE TABLE `mathang` (
  `id` int(3) NOT NULL,
  `name` varchar(30) NOT NULL,
  `coat` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mathang`
--

INSERT INTO `mathang` (`id`, `name`, `coat`) VALUES
(1, 'Iphone XS', 4000000),
(2, 'Honda Wave', 2500000),
(3, 'TV LCD 32inch', 1500200),
(4, 'Laptop HP Elitebook g40', 3400100),
(5, 'Tủ lạnh Panasonic', 2000500),
(6, 'Quạt treo IFAN', 100000);

-- --------------------------------------------------------

--
-- Table structure for table `tracnghiem`
--

CREATE TABLE `tracnghiem` (
  `id` int(3) NOT NULL,
  `question` varchar(200) NOT NULL,
  `ans1` varchar(30) NOT NULL,
  `ans2` varchar(30) NOT NULL,
  `ans3` varchar(30) NOT NULL,
  `ans4` varchar(30) NOT NULL,
  `ans` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tracnghiem`
--

INSERT INTO `tracnghiem` (`id`, `question`, `ans1`, `ans2`, `ans3`, `ans4`, `ans`) VALUES
(1, 'How do you feel about Khai', 'A.beautiful', 'B.frindly', 'C.hot', 'D.so fun', 'A'),
(2, 'Bác kim thang ở lại làm chi?', 'A.Ai biết', 'B.Làm chi', 'C.Đoán xem', 'D.Bán than', 'B'),
(3, 'Hacker đã hack vào twiter gần đây bao nhiêu tuổi?', 'A.2', 'B.13', 'C.25', 'D.17', 'D'),
(4, 'Virus hoành hành gần đây là con nào', 'A.Cúm', 'B.HIV', 'C.Lao', 'D.Covid', 'D');

-- --------------------------------------------------------

--
-- Table structure for table `tudien`
--

CREATE TABLE `tudien` (
  `id` int(3) NOT NULL,
  `eng` varchar(20) NOT NULL,
  `viet` varchar(20) NOT NULL,
  `mean` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tudien`
--

INSERT INTO `tudien` (`id`, `eng`, `viet`, `mean`) VALUES
(1, 'Hello', 'Xin chào', 'Chào hỏi một ai đó'),
(2, 'dog', 'Con chó', 'Một loài thú cưng trong nhà'),
(3, 'Teacher', 'Giáo viên', 'Người truyền đạt kiến thức'),
(4, 'Insert', 'Chèn', 'Thêm kí tự vào'),
(5, 'Home', 'Nhà', 'Mái ấm, nơi bạn trở về'),
(6, 'Coat', 'Áo lạnh', 'Lớp áo mặc khi trời lạnh');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mathang`
--
ALTER TABLE `mathang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tudien`
--
ALTER TABLE `tudien`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `mathang`
--
ALTER TABLE `mathang`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tudien`
--
ALTER TABLE `tudien`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
