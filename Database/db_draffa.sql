-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 30, 2018 at 01:35 PM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_draffa`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_barang`
--

CREATE TABLE `data_barang` (
  `kd_barang` varchar(6) NOT NULL,
  `nama_barang` varchar(25) NOT NULL,
  `stok` int(50) NOT NULL,
  `harga` varchar(10) NOT NULL,
  `harga_jual` varchar(10) NOT NULL,
  `catatan` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_barang`
--

INSERT INTO `data_barang` (`kd_barang`, `nama_barang`, `stok`, `harga`, `harga_jual`, `catatan`) VALUES
('B001', 'Kaos Polos Hitam', 2000, '15000', '20000', 'Merek Gildan'),
('B002', 'Kaos Polos Putih', 2000, '15000', '20000', 'Merek Gildan'),
('B003', 'Gamis', 900, '50000', '55000', 'Warna Merah Ati'),
('B004', 'Kerudung', 2000, '20000', '25000', 'Keren'),
('B005', 'Manset', 3000, '11000', '25000', '');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `kd_member` varchar(7) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `no_tlp` varchar(50) NOT NULL,
  `alamat` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`kd_member`, `nama`, `no_tlp`, `alamat`) VALUES
('M001', 'Riidho', '08192819928', 'Maliki 2'),
('M002', 'Fajar', '08192819289', 'Serab'),
('M003', 'Anis', '0812190292029', 'Cisalak');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE `pembelian` (
  `kd_pembelian` varchar(5) NOT NULL,
  `kd_suplier` varchar(7) NOT NULL,
  `perusahaan` varchar(20) NOT NULL,
  `tgl` date NOT NULL,
  `nama_barang` varchar(25) NOT NULL,
  `jumlah` varchar(20) NOT NULL,
  `harga` varchar(20) NOT NULL,
  `total` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`kd_pembelian`, `kd_suplier`, `perusahaan`, `tgl`, `nama_barang`, `jumlah`, `harga`, `total`) VALUES
('PB001', 'S001', 'Ok Mantap', '2018-07-06', 'Kaos Polos Hitam', '100', '20000', '2000000');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `no_transaksi` varchar(7) NOT NULL,
  `tgl_transaksi` date NOT NULL,
  `kd_barang` varchar(5) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `stok` int(50) NOT NULL,
  `jumlah` int(10) NOT NULL,
  `harga` bigint(10) NOT NULL,
  `total` bigint(10) NOT NULL,
  `bayar` bigint(10) NOT NULL,
  `kembalian` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`no_transaksi`, `tgl_transaksi`, `kd_barang`, `nama_barang`, `stok`, `jumlah`, `harga`, `total`, `bayar`, `kembalian`) VALUES
('PJ001', '2018-07-07', 'B001', 'Kaos Polos Hitam', 2000, 100, 20000, 2000000, 2000000, 0),
('PJ002', '2018-07-13', 'B002', 'Kaos Polos Putih', 2000, 100, 20000, 2000000, 2000000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `kd_supplier` varchar(7) NOT NULL,
  `nama_toko` varchar(15) NOT NULL,
  `barang_dijual` varchar(20) NOT NULL,
  `no_tlp` varchar(13) NOT NULL,
  `alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`kd_supplier`, `nama_toko`, `barang_dijual`, `no_tlp`, `alamat`) VALUES
('S001', 'Ok Mantap', 'Aneka Kaos Polos', '081119383928', 'Bogor'),
('S002', 'Muslimah Kece', 'Gamis', '0819281928', 'Depok'),
('S003', 'Harum', 'Aneka Manset', '0819389289', 'Cijantung');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` varchar(10) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `namauser` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `nama`, `namauser`, `password`) VALUES
('1', 'admin', 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_barang`
--
ALTER TABLE `data_barang`
  ADD PRIMARY KEY (`kd_barang`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`kd_member`);

--
-- Indexes for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`kd_pembelian`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`no_transaksi`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`kd_supplier`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`) USING BTREE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
