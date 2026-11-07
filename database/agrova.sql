-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 07, 2026 at 01:27 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `agrova`
--

-- --------------------------------------------------------

--
-- Table structure for table `kios`
--

CREATE TABLE `kios` (
  `id_kios` int NOT NULL,
  `nama_kios` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `nama_kecamatan` varchar(100) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kios`
--

INSERT INTO `kios` (`id_kios`, `nama_kios`, `nama_kecamatan`) VALUES
(1, 'Toko Tani Makmur', 'Samarinda Ulu'),
(2, 'Kios Subur Jaya', 'Samarinda Utara'),
(3, 'CV Tani Sejahtera', 'Loa Janan Ilir'),
(4, 'Toko Tani Berkah', 'Sambutan'),
(5, 'Kios Tani Mandiri', 'Sungai Kunjang'),
(6, 'UD Tani Subur', 'Samarinda Ilir'),
(7, 'Toko Tani Jaya Abadi', 'Samarinda Kota'),
(8, 'Kios Makmur Sentosa', 'Palaran'),
(9, 'CV Tani Barokah', 'Sambutan Baru'),
(10, 'Toko Tani Lestari', 'Sempaja Selatan'),
(11, 'Kios Subur Makmur', 'Mugirejo'),
(12, 'CV Tani Gemilang', 'Air Putih'),
(13, 'Toko Tani Harapan', 'Sidodadi'),
(14, 'Kios Tani Jaya', 'Teluk Lerong'),
(15, 'CV Tani Utama', 'Baqa'),
(16, 'Kios Tani Barokah II', 'Samarinda Ulu'),
(17, 'Toko Tani Subur Makmur', 'Samarinda Utara'),
(18, 'CV Tani Makmur Jaya', 'Loa Janan Ilir'),
(19, 'anugrah', 'Samarinda Utara'),
(20, 'anugrah', 'Samarinda Ulu');

-- --------------------------------------------------------

--
-- Table structure for table `non_subsidi`
--

CREATE TABLE `non_subsidi` (
  `id_pupuk` int NOT NULL,
  `jumlah_karung_pupuk_nonsubsidi` int NOT NULL,
  `no_po_pupuk` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `non_subsidi`
--

INSERT INTO `non_subsidi` (`id_pupuk`, `jumlah_karung_pupuk_nonsubsidi`, `no_po_pupuk`) VALUES
(61, 150, 998871),
(62, 140, 998872),
(63, 160, 998873),
(64, 200, 998874),
(65, 190, 998875),
(66, 210, 998876),
(67, 120, 998877),
(68, 125, 998878),
(69, 175, 998879),
(70, 180, 998880),
(71, 250, 998881),
(72, 260, 998882),
(73, 130, 998883),
(74, 135, 998884),
(75, 140, 998885),
(76, 145, 998886),
(77, 110, 998887),
(78, 115, 998888),
(79, 90, 998889),
(80, 95, 998890),
(81, 95, 998891),
(82, 100, 998892),
(83, 170, 998893),
(84, 150, 998894),
(85, 130, 998895),
(86, 140, 998896),
(87, 180, 998897),
(88, 160, 998898),
(89, 155, 998899),
(90, 125, 998900),
(91, 145, 998901),
(92, 155, 998902),
(93, 165, 998903),
(94, 205, 998904),
(95, 195, 998905),
(96, 215, 998906),
(97, 125, 998907),
(98, 130, 998908),
(99, 180, 998909),
(100, 185, 998910),
(101, 255, 998911),
(102, 265, 998912),
(103, 135, 998913),
(104, 140, 998914),
(105, 145, 998915),
(106, 150, 998916),
(107, 115, 998917),
(108, 120, 998918),
(109, 95, 998919),
(110, 100, 998920),
(111, 100, 998921),
(112, 105, 998922),
(113, 175, 998923),
(114, 155, 998924),
(115, 135, 998925),
(116, 145, 998926),
(117, 185, 998927),
(118, 165, 998928),
(119, 160, 998929),
(120, 130, 998930),
(121, 135, 998931),
(122, 125, 998932),
(123, 145, 998933),
(124, 195, 998934),
(125, 185, 998935),
(126, 205, 998936),
(127, 115, 998937),
(128, 120, 998938),
(129, 170, 998939),
(130, 175, 998940);

-- --------------------------------------------------------

--
-- Table structure for table `pengelola`
--

CREATE TABLE `pengelola` (
  `id_user` int NOT NULL,
  `tipe_user` enum('pengelola','petani','penyalur') COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'pengelola',
  `jabatan` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `nip` varchar(20) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengelola`
--

INSERT INTO `pengelola` (`id_user`, `tipe_user`, `jabatan`, `nip`) VALUES
(1, 'pengelola', 'Koordinator Wilayah', '198001012005011001'),
(2, 'pengelola', 'Staff Administrasi', '198505052010012002'),
(3, 'pengelola', 'Pengawas Lapangan', '199003102015031003');

-- --------------------------------------------------------

--
-- Table structure for table `penyalur`
--

CREATE TABLE `penyalur` (
  `id_user` int NOT NULL,
  `tipe_user` enum('pengelola','petani','penyalur') COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'penyalur',
  `nomor_izin_usaha` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `nama_kios` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `kios_id_kios` int NOT NULL,
  `no_telepon` varchar(25) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penyalur`
--

INSERT INTO `penyalur` (`id_user`, `tipe_user`, `nomor_izin_usaha`, `nama_kios`, `kios_id_kios`, `no_telepon`) VALUES
(4, 'penyalur', 'SIUP/2023/001', 'Toko Tani Makmur', 1, NULL),
(5, 'penyalur', 'SIUP/2023/002', 'Kios Subur Jaya', 2, NULL),
(6, 'penyalur', 'SIUP/2023/003', 'CV Tani Sejahtera', 3, NULL),
(7, 'penyalur', 'SIUP/2023/004', 'Toko Tani Berkah', 4, NULL),
(8, 'penyalur', 'SIUP/2023/005', 'Kios Tani Mandiri', 5, NULL),
(9, 'penyalur', 'SIUP/2023/006', 'UD Tani Subur', 6, NULL),
(30, 'penyalur', 'SIUP/2026/2500', 'anugrah', 20, '0825361728374');

-- --------------------------------------------------------

--
-- Table structure for table `penyaluran`
--

CREATE TABLE `penyaluran` (
  `id_penyaluran` int NOT NULL,
  `status_kirim` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'Proses',
  `tanggal_kirim` date NOT NULL,
  `tanggal_terima` date DEFAULT NULL,
  `pengelola_id_user` int DEFAULT NULL,
  `jumlah_karung` int NOT NULL,
  `total_berat_kg` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `kios_id_kios` int DEFAULT NULL
) ;

--
-- Dumping data for table `penyaluran`
--

INSERT INTO `penyaluran` (`id_penyaluran`, `status_kirim`, `tanggal_kirim`, `tanggal_terima`, `pengelola_id_user`, `jumlah_karung`, `total_berat_kg`, `kios_id_kios`) VALUES
(1, 'Selesai', '2026-03-01', '2026-03-02', 1, 50, '2500 Kg', 1),
(2, 'Selesai', '2026-03-03', '2026-03-04', 2, 40, '2000 Kg', 2),
(3, 'Proses', '2026-03-05', NULL, 3, 45, '2250 Kg', 3),
(4, 'Selesai', '2026-03-06', '2026-03-07', 1, 30, '1500 Kg', 4),
(5, 'Selesai', '2026-03-08', '2026-03-09', 2, 60, '3000 Kg', 5),
(6, 'Proses', '2026-03-10', NULL, 3, 35, '1750 Kg', 6),
(7, 'Selesai', '2026-03-11', '2026-03-12', 1, 55, '2750 Kg', 7),
(8, 'Selesai', '2026-03-13', '2026-03-14', 2, 40, '2000 Kg', 8),
(9, 'Proses', '2026-03-15', NULL, 3, 50, '2500 Kg', 9),
(10, 'Selesai', '2026-03-16', '2026-03-17', 1, 65, '3250 Kg', 10),
(11, 'Selesai', '2026-03-18', '2026-03-19', 2, 15, '750 Kg', 11),
(12, 'Selesai', '2026-03-20', '2026-03-21', 3, 20, '1000 Kg', 12),
(13, 'Proses', '2026-03-22', NULL, 1, 12, '600 Kg', 13),
(14, 'Selesai', '2026-03-23', '2026-03-24', 2, 17, '850 Kg', 14),
(15, 'Selesai', '2026-03-25', '2026-03-26', 3, 25, '1250 Kg', 15),
(16, 'Selesai', '2026-03-27', '2026-03-28', 1, 30, '1500 Kg', 16),
(17, 'Proses', '2026-03-29', NULL, 2, 40, '2000 Kg', 17);

-- --------------------------------------------------------

--
-- Table structure for table `petani`
--

CREATE TABLE `petani` (
  `id_user` int NOT NULL,
  `tipe_user` enum('pengelola','petani','penyalur') COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'petani',
  `nik` varchar(16) COLLATE utf8mb4_general_ci NOT NULL,
  `luas_lahan` decimal(4,2) NOT NULL,
  `golongan` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `kios_id_kios` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `petani`
--

INSERT INTO `petani` (`id_user`, `tipe_user`, `nik`, `luas_lahan`, `golongan`, `kios_id_kios`) VALUES
(10, 'petani', '6471011234560001', '1.50', 'Gol B', 1),
(11, 'petani', '6471011234560002', '2.20', 'Gol A', 2),
(12, 'petani', '6471011234560003', '0.80', 'Gol C', 3),
(13, 'petani', '6471011234560004', '1.20', 'Gol B', 4),
(14, 'petani', '6471011234560005', '3.00', 'Gol A', 5),
(15, 'petani', '6471011234560006', '0.50', 'Gol C', 6),
(16, 'petani', '6471011234560007', '1.75', 'Gol B', 7),
(17, 'petani', '6471011234560008', '2.00', 'Gol B', 8),
(18, 'petani', '6471011234560009', '1.10', 'Gol B', 9),
(29, 'petani', '6452736481927364', '20.00', 'Gol A', 1);

-- --------------------------------------------------------

--
-- Table structure for table `pupuk`
--

CREATE TABLE `pupuk` (
  `id_pupuk` int NOT NULL,
  `nama_pupuk` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `kategori_pupuk` enum('Subsidi','Nonsubsidi') COLLATE utf8mb4_general_ci NOT NULL,
  `satuan` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `stok_pupuk` int NOT NULL,
  `deskripsi` text COLLATE utf8mb4_general_ci,
  `penyaluran_id_penyaluran` int DEFAULT NULL
) ;

--
-- Dumping data for table `pupuk`
--

INSERT INTO `pupuk` (`id_pupuk`, `nama_pupuk`, `kategori_pupuk`, `satuan`, `stok_pupuk`, `deskripsi`, `penyaluran_id_penyaluran`) VALUES
(1, 'Urea', 'Subsidi', 'Kg', 2500, 'Urea Subsidi Batch 1', 1),
(2, 'Urea', 'Subsidi', 'Kg', 1900, 'Urea Subsidi Batch 2', 2),
(3, 'Urea', 'Subsidi', 'Kg', 2100, 'Urea Subsidi Batch 3', 3),
(4, 'Urea', 'Subsidi', 'Kg', 1850, 'Urea Subsidi Batch 4', 4),
(5, 'Urea', 'Subsidi', 'Kg', 2050, 'Urea Subsidi Batch 5', 5),
(6, 'Urea', 'Subsidi', 'Kg', 1950, 'Urea Subsidi Batch 6', 6),
(7, 'Urea', 'Subsidi', 'Kg', 2150, 'Urea Subsidi Batch 7', 7),
(8, 'Urea', 'Subsidi', 'Kg', 2200, 'Urea Subsidi Batch 8', 8),
(9, 'Urea', 'Subsidi', 'Kg', 1800, 'Urea Subsidi Batch 9', 9),
(10, 'Urea', 'Subsidi', 'Kg', 2250, 'Urea Subsidi Batch 10', 10),
(11, 'NPK', 'Subsidi', 'Kg', 2500, 'NPK Subsidi Batch 1', 11),
(12, 'NPK', 'Subsidi', 'Kg', 2400, 'NPK Subsidi Batch 2', 12),
(13, 'NPK', 'Subsidi', 'Kg', 2300, 'NPK Subsidi Batch 3', 13),
(14, 'NPK', 'Subsidi', 'Kg', 2250, 'NPK Subsidi Batch 4', 14),
(15, 'NPK', 'Subsidi', 'Kg', 2600, 'NPK Subsidi Batch 5', 15),
(16, 'NPK', 'Subsidi', 'Kg', 2350, 'NPK Subsidi Batch 6', 16),
(17, 'NPK', 'Subsidi', 'Kg', 2450, 'NPK Subsidi Batch 7', 17),
(18, 'NPK', 'Subsidi', 'Kg', 2550, 'NPK Subsidi Batch 8', NULL),
(19, 'NPK', 'Subsidi', 'Kg', 2200, 'NPK Subsidi Batch 9', 1),
(20, 'NPK', 'Subsidi', 'Kg', 2650, 'NPK Subsidi Batch 10', 2),
(21, 'NPK untuk kakao', 'Subsidi', 'Kg', 1500, 'NPK Kakao Batch 1', 3),
(22, 'NPK untuk kakao', 'Subsidi', 'Kg', 1450, 'NPK Kakao Batch 2', 4),
(23, 'NPK untuk kakao', 'Subsidi', 'Kg', 1600, 'NPK Kakao Batch 3', 5),
(24, 'NPK untuk kakao', 'Subsidi', 'Kg', 1550, 'NPK Kakao Batch 4', 6),
(25, 'NPK untuk kakao', 'Subsidi', 'Kg', 1700, 'NPK Kakao Batch 5', 7),
(26, 'NPK untuk kakao', 'Subsidi', 'Kg', 1400, 'NPK Kakao Batch 6', 8),
(27, 'NPK untuk kakao', 'Subsidi', 'Kg', 1650, 'NPK Kakao Batch 7', 9),
(28, 'NPK untuk kakao', 'Subsidi', 'Kg', 1750, 'NPK Kakao Batch 8', 10),
(29, 'NPK untuk kakao', 'Subsidi', 'Kg', 1350, 'NPK Kakao Batch 9', 11),
(30, 'NPK untuk kakao', 'Subsidi', 'Kg', 1800, 'NPK Kakao Batch 10', 12),
(31, 'NPK Phonska', 'Subsidi', 'Kg', 1200, 'NPK Phonska Subsidi Batch 1', 13),
(32, 'NPK Phonska', 'Subsidi', 'Kg', 1150, 'NPK Phonska Subsidi Batch 2', 14),
(33, 'NPK Phonska', 'Subsidi', 'Kg', 1300, 'NPK Phonska Subsidi Batch 3', 15),
(34, 'NPK Phonska', 'Subsidi', 'Kg', 1250, 'NPK Phonska Subsidi Batch 4', 16),
(35, 'NPK Phonska', 'Subsidi', 'Kg', 1400, 'NPK Phonska Subsidi Batch 5', 17),
(36, 'NPK Phonska', 'Subsidi', 'Kg', 1100, 'NPK Phonska Subsidi Batch 6', NULL),
(37, 'NPK Phonska', 'Subsidi', 'Kg', 1350, 'NPK Phonska Subsidi Batch 7', 1),
(38, 'NPK Phonska', 'Subsidi', 'Kg', 1450, 'NPK Phonska Subsidi Batch 8', 2),
(39, 'NPK Phonska', 'Subsidi', 'Kg', 1050, 'NPK Phonska Subsidi Batch 9', 3),
(40, 'NPK Phonska', 'Subsidi', 'Kg', 1500, 'NPK Phonska Subsidi Batch 10', 4),
(41, 'ZA Subsidi', 'Subsidi', 'Kg', 1400, 'ZA Subsidi Batch 1', 5),
(42, 'ZA Subsidi', 'Subsidi', 'Kg', 1350, 'ZA Subsidi Batch 2', 6),
(43, 'ZA Subsidi', 'Subsidi', 'Kg', 1450, 'ZA Subsidi Batch 3', 7),
(44, 'ZA Subsidi', 'Subsidi', 'Kg', 1500, 'ZA Subsidi Batch 4', 8),
(45, 'ZA Subsidi', 'Subsidi', 'Kg', 1300, 'ZA Subsidi Batch 5', 9),
(46, 'ZA Subsidi', 'Subsidi', 'Kg', 1550, 'ZA Subsidi Batch 6', 10),
(47, 'ZA Subsidi', 'Subsidi', 'Kg', 1600, 'ZA Subsidi Batch 7', 11),
(48, 'ZA Subsidi', 'Subsidi', 'Kg', 1250, 'ZA Subsidi Batch 8', 12),
(49, 'ZA Subsidi', 'Subsidi', 'Kg', 1650, 'ZA Subsidi Batch 9', 13),
(50, 'ZA Subsidi', 'Subsidi', 'Kg', 1700, 'ZA Subsidi Batch 10', 14),
(51, 'Dolomit Subsidi', 'Subsidi', 'Kg', 900, 'Dolomit Subsidi Batch 1', 15),
(52, 'Dolomit Subsidi', 'Subsidi', 'Kg', 950, 'Dolomit Subsidi Batch 2', 16),
(53, 'Dolomit Subsidi', 'Subsidi', 'Kg', 850, 'Dolomit Subsidi Batch 3', 17),
(54, 'Dolomit Subsidi', 'Subsidi', 'Kg', 1000, 'Dolomit Subsidi Batch 4', NULL),
(55, 'Dolomit Subsidi', 'Subsidi', 'Kg', 800, 'Dolomit Subsidi Batch 5', 1),
(56, 'Dolomit Subsidi', 'Subsidi', 'Kg', 1050, 'Dolomit Subsidi Batch 6', 2),
(57, 'Dolomit Subsidi', 'Subsidi', 'Kg', 1100, 'Dolomit Subsidi Batch 7', 3),
(58, 'Dolomit Subsidi', 'Subsidi', 'Kg', 750, 'Dolomit Subsidi Batch 8', 4),
(59, 'Dolomit Subsidi', 'Subsidi', 'Kg', 1150, 'Dolomit Subsidi Batch 9', 5),
(60, 'Dolomit Subsidi', 'Subsidi', 'Kg', 1200, 'Dolomit Subsidi Batch 10', 6),
(61, 'Urea nonsubsidi', 'Nonsubsidi', 'Kg', 2200, 'Urea Nonsubsidi Batch 1', 7),
(62, 'Urea nonsubsidi', 'Nonsubsidi', 'Kg', 2100, 'Urea Nonsubsidi Batch 2', 8),
(63, 'Urea nonsubsidi', 'Nonsubsidi', 'Kg', 2300, 'Urea Nonsubsidi Batch 3', 9),
(64, 'Urea nonsubsidi', 'Nonsubsidi', 'Kg', 2050, 'Urea Nonsubsidi Batch 4', 10),
(65, 'Urea nonsubsidi', 'Nonsubsidi', 'Kg', 2400, 'Urea Nonsubsidi Batch 5', 11),
(66, 'Urea nonsubsidi', 'Nonsubsidi', 'Kg', 1950, 'Urea Nonsubsidi Batch 6', 12),
(67, 'Urea nonsubsidi', 'Nonsubsidi', 'Kg', 2450, 'Urea Nonsubsidi Batch 7', 13),
(68, 'Urea nonsubsidi', 'Nonsubsidi', 'Kg', 2500, 'Urea Nonsubsidi Batch 8', 14),
(69, 'Urea nonsubsidi', 'Nonsubsidi', 'Kg', 1900, 'Urea Nonsubsidi Batch 9', 15),
(70, 'Urea nonsubsidi', 'Nonsubsidi', 'Kg', 2550, 'Urea Nonsubsidi Batch 10', 16),
(71, 'NPK nonsubsidi', 'Nonsubsidi', 'Kg', 1800, 'NPK Nonsubsidi Batch 1', 17),
(72, 'NPK nonsubsidi', 'Nonsubsidi', 'Kg', 1750, 'NPK Nonsubsidi Batch 2', NULL),
(73, 'NPK nonsubsidi', 'Nonsubsidi', 'Kg', 1900, 'NPK Nonsubsidi Batch 3', 1),
(74, 'NPK nonsubsidi', 'Nonsubsidi', 'Kg', 1850, 'NPK Nonsubsidi Batch 4', 2),
(75, 'NPK nonsubsidi', 'Nonsubsidi', 'Kg', 2000, 'NPK Nonsubsidi Batch 5', 3),
(76, 'NPK nonsubsidi', 'Nonsubsidi', 'Kg', 1700, 'NPK Nonsubsidi Batch 6', 4),
(77, 'NPK nonsubsidi', 'Nonsubsidi', 'Kg', 2050, 'NPK Nonsubsidi Batch 7', 5),
(78, 'NPK nonsubsidi', 'Nonsubsidi', 'Kg', 2100, 'NPK Nonsubsidi Batch 8', 6),
(79, 'NPK nonsubsidi', 'Nonsubsidi', 'Kg', 1650, 'NPK Nonsubsidi Batch 9', 7),
(80, 'NPK nonsubsidi', 'Nonsubsidi', 'Kg', 2150, 'NPK Nonsubsidi Batch 10', 8),
(81, 'SP-36', 'Nonsubsidi', 'Kg', 1000, 'SP-36 Batch 1', 9),
(82, 'SP-36', 'Nonsubsidi', 'Kg', 1050, 'SP-36 Batch 2', 10),
(83, 'SP-36', 'Nonsubsidi', 'Kg', 950, 'SP-36 Batch 3', 11),
(84, 'SP-36', 'Nonsubsidi', 'Kg', 1100, 'SP-36 Batch 4', 12),
(85, 'SP-36', 'Nonsubsidi', 'Kg', 900, 'SP-36 Batch 5', 13),
(86, 'SP-36', 'Nonsubsidi', 'Kg', 1150, 'SP-36 Batch 6', 14),
(87, 'SP-36', 'Nonsubsidi', 'Kg', 1200, 'SP-36 Batch 7', 15),
(88, 'SP-36', 'Nonsubsidi', 'Kg', 850, 'SP-36 Batch 8', 16),
(89, 'SP-36', 'Nonsubsidi', 'Kg', 1250, 'SP-36 Batch 9', 17),
(90, 'SP-36', 'Nonsubsidi', 'Kg', 1300, 'SP-36 Batch 10', NULL),
(91, 'ZA', 'Nonsubsidi', 'Kg', 1500, 'ZA Batch 1', 1),
(92, 'ZA', 'Nonsubsidi', 'Kg', 1550, 'ZA Batch 2', 2),
(93, 'ZA', 'Nonsubsidi', 'Kg', 1450, 'ZA Batch 3', 3),
(94, 'ZA', 'Nonsubsidi', 'Kg', 1600, 'ZA Batch 4', 4),
(95, 'ZA', 'Nonsubsidi', 'Kg', 1400, 'ZA Batch 5', 5),
(96, 'ZA', 'Nonsubsidi', 'Kg', 1650, 'ZA Batch 6', 6),
(97, 'ZA', 'Nonsubsidi', 'Kg', 1700, 'ZA Batch 7', 7),
(98, 'ZA', 'Nonsubsidi', 'Kg', 1350, 'ZA Batch 8', 8),
(99, 'ZA', 'Nonsubsidi', 'Kg', 1750, 'ZA Batch 9', 9),
(100, 'ZA', 'Nonsubsidi', 'Kg', 1800, 'ZA Batch 10', 10),
(101, 'KCl', 'Nonsubsidi', 'Kg', 800, 'KCl Batch 1', 11),
(102, 'KCl', 'Nonsubsidi', 'Kg', 850, 'KCl Batch 2', 12),
(103, 'KCl', 'Nonsubsidi', 'Kg', 750, 'KCl Batch 3', 13),
(104, 'KCl', 'Nonsubsidi', 'Kg', 900, 'KCl Batch 4', 14),
(105, 'KCl', 'Nonsubsidi', 'Kg', 700, 'KCl Batch 5', 15),
(106, 'KCl', 'Nonsubsidi', 'Kg', 950, 'KCl Batch 6', 16),
(107, 'KCl', 'Nonsubsidi', 'Kg', 1000, 'KCl Batch 7', 17),
(108, 'KCl', 'Nonsubsidi', 'Kg', 650, 'KCl Batch 8', NULL),
(109, 'KCl', 'Nonsubsidi', 'Kg', 1050, 'KCl Batch 9', 1),
(110, 'KCl', 'Nonsubsidi', 'Kg', 1100, 'KCl Batch 10', 2),
(111, 'TSP', 'Nonsubsidi', 'Kg', 900, 'TSP Batch 1', 3),
(112, 'TSP', 'Nonsubsidi', 'Kg', 950, 'TSP Batch 2', 4),
(113, 'TSP', 'Nonsubsidi', 'Kg', 850, 'TSP Batch 3', 5),
(114, 'TSP', 'Nonsubsidi', 'Kg', 1000, 'TSP Batch 4', 6),
(115, 'TSP', 'Nonsubsidi', 'Kg', 800, 'TSP Batch 5', 7),
(116, 'TSP', 'Nonsubsidi', 'Kg', 1050, 'TSP Batch 6', 8),
(117, 'TSP', 'Nonsubsidi', 'Kg', 1100, 'TSP Batch 7', 9),
(118, 'TSP', 'Nonsubsidi', 'Kg', 750, 'TSP Batch 8', 10),
(119, 'TSP', 'Nonsubsidi', 'Kg', 1150, 'TSP Batch 9', 11),
(120, 'TSP', 'Nonsubsidi', 'Kg', 1200, 'TSP Batch 10', 12),
(121, 'DAP', 'Nonsubsidi', 'Kg', 1100, 'DAP Batch 1', 13),
(122, 'DAP', 'Nonsubsidi', 'Kg', 1150, 'DAP Batch 2', 14),
(123, 'DAP', 'Nonsubsidi', 'Kg', 1050, 'DAP Batch 3', 15),
(124, 'DAP', 'Nonsubsidi', 'Kg', 1200, 'DAP Batch 4', 16),
(125, 'DAP', 'Nonsubsidi', 'Kg', 1000, 'DAP Batch 5', 17),
(126, 'DAP', 'Nonsubsidi', 'Kg', 1150, 'DAP Batch 6', NULL),
(127, 'DAP', 'Nonsubsidi', 'Kg', 1050, 'DAP Batch 7', 1),
(128, 'DAP', 'Nonsubsidi', 'Kg', 1200, 'DAP Batch 8', 2),
(129, 'DAP', 'Nonsubsidi', 'Kg', 1000, 'DAP Batch 9', 3),
(130, 'DAP', 'Nonsubsidi', 'Kg', 1100, 'DAP Batch 10', 4);

-- --------------------------------------------------------

--
-- Table structure for table `subsidi`
--

CREATE TABLE `subsidi` (
  `id_pupuk` int NOT NULL,
  `kuota_subsidi` int NOT NULL,
  `harga_normal` decimal(12,2) NOT NULL,
  `harga_het` decimal(12,2) NOT NULL,
  `kuota_alokasi` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subsidi`
--

INSERT INTO `subsidi` (`id_pupuk`, `kuota_subsidi`, `harga_normal`, `harga_het`, `kuota_alokasi`) VALUES
(1, 500, '150000.00', '115000.00', 600),
(2, 480, '150000.00', '112500.00', 580),
(3, 520, '150000.00', '112500.00', 620),
(4, 460, '150000.00', '112500.00', 550),
(5, 500, '150000.00', '112500.00', 600),
(6, 480, '150000.00', '112500.00', 580),
(7, 520, '150000.00', '112500.00', 620),
(8, 460, '150000.00', '112500.00', 550),
(9, 400, '150000.00', '112500.00', 500),
(10, 390, '150000.00', '112500.00', 480),
(11, 410, '150000.00', '112500.00', 510),
(12, 380, '150000.00', '112500.00', 450),
(13, 400, '150000.00', '112500.00', 500),
(14, 390, '150000.00', '112500.00', 480),
(15, 410, '150000.00', '112500.00', 510),
(16, 380, '150000.00', '112500.00', 450),
(17, 430, '150000.00', '112500.00', 530),
(18, 440, '150000.00', '112500.00', 540),
(19, 370, '150000.00', '112500.00', 430),
(20, 450, '150000.00', '112500.00', 550),
(21, 450, '160000.00', '120000.00', 550),
(22, 440, '160000.00', '120000.00', 540),
(23, 470, '160000.00', '120000.00', 570),
(24, 460, '160000.00', '120000.00', 560),
(25, 450, '160000.00', '120000.00', 550),
(26, 440, '160000.00', '120000.00', 540),
(27, 470, '160000.00', '120000.00', 570),
(28, 460, '160000.00', '120000.00', 560),
(29, 420, '160000.00', '120000.00', 520),
(30, 480, '160000.00', '120000.00', 590),
(31, 300, '100000.00', '85000.00', 350),
(32, 290, '100000.00', '85000.00', 340),
(33, 320, '100000.00', '85000.00', 370),
(34, 310, '100000.00', '85000.00', 360),
(35, 300, '100000.00', '85000.00', 350),
(36, 290, '100000.00', '85000.00', 340),
(37, 320, '100000.00', '85000.00', 370),
(38, 310, '100000.00', '85000.00', 360),
(39, 330, '100000.00', '85000.00', 390),
(40, 340, '100000.00', '85000.00', 400),
(41, 350, '120000.00', '95000.00', 420),
(42, 360, '120000.00', '95000.00', 430),
(43, 340, '120000.00', '95000.00', 410),
(44, 370, '120000.00', '95000.00', 440),
(45, 330, '120000.00', '95000.00', 390),
(46, 380, '120000.00', '95000.00', 450),
(47, 390, '120000.00', '95000.00', 460),
(48, 320, '120000.00', '95000.00', 380),
(49, 400, '120000.00', '95000.00', 480),
(50, 410, '120000.00', '95000.00', 490),
(51, 280, '90000.00', '75000.00', 330),
(52, 290, '90000.00', '75000.00', 340),
(53, 270, '90000.00', '75000.00', 320),
(54, 300, '90000.00', '75000.00', 360),
(55, 260, '90000.00', '75000.00', 310),
(56, 310, '90000.00', '75000.00', 370),
(57, 320, '90000.00', '75000.00', 380),
(58, 250, '90000.00', '75000.00', 300),
(59, 330, '90000.00', '75000.00', 390),
(60, 340, '90000.00', '75000.00', 400);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int NOT NULL,
  `nama` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `no_hp` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `tipe_user` enum('pengelola','petani','penyalur') COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `nama`, `email`, `password`, `no_hp`, `tipe_user`) VALUES
(1, 'Budi Santoso', 'budi@perusahaan.com', 'e8979d2eb704c94fa2fa5044edba1c29232526eec3965ffc64308b6783f2de12', '081234567801', 'pengelola'),
(2, 'Siti Aminah', 'siti@perusahaan.com', '71c6e47969179c1e831fcf41f4979a3557290a65d7925e6760cfd316389f0729', '081234567802', 'pengelola'),
(3, 'Ahmad Fauzi', 'ahmad@perusahaan.com', 'f9a2533c2176415031a77ffb0d1c8d2a6b61b24429f87c597817a3b127d42668', '081234567803', 'pengelola'),
(4, 'Toko Tani Makmur', 'makmur@kios.com', '53b7084a9e7e82d72c87dedd7c49dbca87a419f36fa758bcff92d7da6c2f2efe', '082111222301', 'penyalur'),
(5, 'Kios Subur Jaya', 'subur@kios.com', '9f6ae0aa00a2a6e5c9b5ee19c138b6490936ad1f0b1cd434c4a9496a49bf0b72', '082111222302', 'penyalur'),
(6, 'CV Tani Sejahtera', 'sejahtera@kios.com', 'ee7105686891d619ebfd32192ea163296466a64aa5f8df5d40da00c9a4417003', '082111222303', 'penyalur'),
(7, 'Toko Tani Berkah', 'berkah@kios.com', '84cba45c20553ead89a6cf0fdd455da3db2ceb2e4cff6dea74eaaa8097af9712', '082111222304', 'penyalur'),
(8, 'Kios Tani Mandiri', 'mandiri@kios.com', 'faa69da2fbe58ba635b9a624ad9a420ab67458b179e2e7fce6f332d4d3210ebd', '082111222305', 'penyalur'),
(9, 'UD Tani Subur', 'udsubur@kios.com', '7144dee95b53b01d7cd97072198ccf748fe8ba1c99a1eab63c4b32a51990c3fc', '082111222306', 'penyalur'),
(10, 'Joko Widodo', 'joko@petani.com', 'eb0128a257530673ba3d8e6912878ea54823990d78474de911d999eafebd2428', '081999888777', 'petani'),
(11, 'Supriyanto', 'supri@petani.com', 'f34d74ce32e3fda0e47a15f6d559a082993d6303b52442c99fb7b705fc0f9cd8', '085222333402', 'petani'),
(12, 'Wagimin', 'wagimin@petani.com', '42a02e43b7dbe273dd96841cce5860e77d2f9cfa62baea46e8233645a109e2bc', '085222333403', 'petani'),
(13, 'Slamet Riyadi', 'slamet@petani.com', '185b01ee0cea555fe2cc8cafe9cdd63c312ea2cf896db3ccb4e881d6107855d8', '085222333404', 'petani'),
(14, 'Hartono', 'hartono@petani.com', 'f8132785e27bc555b5d9cddd988d5869ef633ce3134632fd27a5154127a38c82', '085222333405', 'petani'),
(15, 'Mulyono', 'mulyono@petani.com', '9d3e4ff21d2517e6975ad510ef9a276e581e193c5791b1359bf64928c7b35f32', '085222333406', 'petani'),
(16, 'Sutrisno', 'sutrisno@petani.com', '58cdf14e059d0c916c1e96b03067f5d14b7d2d2a94f67c4c0fd0679b62ca560a', '085222333407', 'petani'),
(17, 'Sugeng Raharjo', 'sugeng@petani.com', '1287d0899d99b3c36b1013cce97de79669997e1005986057f564b1c45ac3de02', '085222333408', 'petani'),
(18, 'Parno', 'parno@petani.com', '56cb9d4d14e00477cfc35a8af595d712f91fbada1f88d6bbcf5b5e97bd0c1c4a', '085222333409', 'petani'),
(29, 'elen', 'elen@petani.com', '2052c12d55e5fd01c4f9543e37b1a4ab7c72afa23766a5b588c7f7aa5179af12', '082111222301', 'petani'),
(30, 'anugrah', 'anugrah@kios.com', '1017b0c1594140b0645582a16a55247b0a8a111d4a57f7318856dce350bbb752', '0825361728374', 'penyalur');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kios`
--
ALTER TABLE `kios`
  ADD PRIMARY KEY (`id_kios`);

--
-- Indexes for table `non_subsidi`
--
ALTER TABLE `non_subsidi`
  ADD PRIMARY KEY (`id_pupuk`),
  ADD UNIQUE KEY `non_subsidi_no_po_UK` (`no_po_pupuk`);

--
-- Indexes for table `pengelola`
--
ALTER TABLE `pengelola`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `pengelola_nip_UK` (`nip`),
  ADD KEY `pengelola_user_FK` (`id_user`,`tipe_user`);

--
-- Indexes for table `penyalur`
--
ALTER TABLE `penyalur`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `penyalur_izin_UK` (`nomor_izin_usaha`),
  ADD KEY `penyalur_user_FK` (`id_user`,`tipe_user`),
  ADD KEY `penyalur_kios_FK` (`kios_id_kios`);

--
-- Indexes for table `penyaluran`
--
ALTER TABLE `penyaluran`
  ADD PRIMARY KEY (`id_penyaluran`),
  ADD KEY `penyaluran_pengelola_FK` (`pengelola_id_user`),
  ADD KEY `penyaluran_kios_FK` (`kios_id_kios`);

--
-- Indexes for table `petani`
--
ALTER TABLE `petani`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `petani_nik_UK` (`nik`),
  ADD KEY `petani_user_FK` (`id_user`,`tipe_user`),
  ADD KEY `petani_kios_FK` (`kios_id_kios`);

--
-- Indexes for table `pupuk`
--
ALTER TABLE `pupuk`
  ADD PRIMARY KEY (`id_pupuk`),
  ADD KEY `pupuk_penyaluran_FK` (`penyaluran_id_penyaluran`);

--
-- Indexes for table `subsidi`
--
ALTER TABLE `subsidi`
  ADD PRIMARY KEY (`id_pupuk`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `user_tipe_UK` (`id_user`,`tipe_user`),
  ADD UNIQUE KEY `user_email_UK` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kios`
--
ALTER TABLE `kios`
  MODIFY `id_kios` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `penyaluran`
--
ALTER TABLE `penyaluran`
  MODIFY `id_penyaluran` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pupuk`
--
ALTER TABLE `pupuk`
  MODIFY `id_pupuk` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `non_subsidi`
--
ALTER TABLE `non_subsidi`
  ADD CONSTRAINT `non_subsidi_pupuk_FK` FOREIGN KEY (`id_pupuk`) REFERENCES `pupuk` (`id_pupuk`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pengelola`
--
ALTER TABLE `pengelola`
  ADD CONSTRAINT `pengelola_user_FK` FOREIGN KEY (`id_user`,`tipe_user`) REFERENCES `user` (`id_user`, `tipe_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `penyalur`
--
ALTER TABLE `penyalur`
  ADD CONSTRAINT `penyalur_kios_FK` FOREIGN KEY (`kios_id_kios`) REFERENCES `kios` (`id_kios`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `penyalur_user_FK` FOREIGN KEY (`id_user`,`tipe_user`) REFERENCES `user` (`id_user`, `tipe_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `penyaluran`
--
ALTER TABLE `penyaluran`
  ADD CONSTRAINT `penyaluran_kios_FK` FOREIGN KEY (`kios_id_kios`) REFERENCES `kios` (`id_kios`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `penyaluran_pengelola_FK` FOREIGN KEY (`pengelola_id_user`) REFERENCES `pengelola` (`id_user`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `petani`
--
ALTER TABLE `petani`
  ADD CONSTRAINT `petani_kios_FK` FOREIGN KEY (`kios_id_kios`) REFERENCES `kios` (`id_kios`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `petani_user_FK` FOREIGN KEY (`id_user`,`tipe_user`) REFERENCES `user` (`id_user`, `tipe_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pupuk`
--
ALTER TABLE `pupuk`
  ADD CONSTRAINT `pupuk_penyaluran_FK` FOREIGN KEY (`penyaluran_id_penyaluran`) REFERENCES `penyaluran` (`id_penyaluran`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `subsidi`
--
ALTER TABLE `subsidi`
  ADD CONSTRAINT `subsidi_pupuk_FK` FOREIGN KEY (`id_pupuk`) REFERENCES `pupuk` (`id_pupuk`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
