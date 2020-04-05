-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Inang: 127.0.0.1
-- Waktu pembuatan: 12 Des 2016 pada 11.30
-- Versi Server: 5.6.14
-- Versi PHP: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Basis data: `kredit_motor`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_hitungan`
--

CREATE TABLE IF NOT EXISTS `data_hitungan` (
  `hdp` varchar(20) NOT NULL,
  `hbunga` varchar(10) NOT NULL,
  `hdenda` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `data_hitungan`
--

INSERT INTO `data_hitungan` (`hdp`, `hbunga`, `hdenda`) VALUES
('2000000', '6', '0.2');

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_merek`
--

CREATE TABLE IF NOT EXISTS `data_merek` (
  `merek` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `data_merek`
--

INSERT INTO `data_merek` (`merek`) VALUES
('YAMAHA'),
('HONDA'),
('SUZUKI');

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_motor`
--

CREATE TABLE IF NOT EXISTS `data_motor` (
  `id` int(225) NOT NULL AUTO_INCREMENT,
  `mkode` varchar(100) NOT NULL,
  `mnopol` varchar(10) NOT NULL,
  `mmerek` varchar(10) NOT NULL,
  `mtahun` varchar(4) NOT NULL,
  `mtype` varchar(30) NOT NULL,
  `mjenis` varchar(10) NOT NULL,
  `mharga` varchar(30) NOT NULL,
  `ma_11x` varchar(30) NOT NULL,
  `mbunga11` varchar(50) NOT NULL,
  `ma_23x` varchar(30) NOT NULL,
  `mbunga23` varchar(50) NOT NULL,
  `ma_35x` varchar(30) NOT NULL,
  `mbunga35` varchar(50) NOT NULL,
  `mdp` varchar(20) NOT NULL,
  `mbunga` varchar(5) NOT NULL,
  `mketerangan` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mkode` (`mkode`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data untuk tabel `data_motor`
--

INSERT INTO `data_motor` (`id`, `mkode`, `mnopol`, `mmerek`, `mtahun`, `mtype`, `mjenis`, `mharga`, `ma_11x`, `mbunga11`, `ma_23x`, `mbunga23`, `ma_35x`, `mbunga35`, `mdp`, `mbunga`, `mketerangan`) VALUES
(1, 'M001', 'B 360 BGT', 'HONDA', '2012', 'MEGA PRO', 'ROAD BIKE', '1200000', '11111', '', '22222', '', '33333', '0', '200000000', '', 'TERJUAL'),
(2, 'M002', 'T 8788 MKS', 'YAMAHA', '2010', 'JUPITER MX', 'BEBEK', '8000000', '100000', '', '200000', '', '30000', '0', '1000000', '', 'TERJUAL'),
(3, 'M003', 'T 2017 XXX', 'SUZUKI', '2014', 'SATRIA', 'SPORT', '15000000', '122222', '', '133333', '', '22222', '0', '100000', '', 'TERJUAL'),
(4, 'M004', 'B 1021 KKN', 'HONDA', '2010', 'MIO', 'BEBEK', '8000000', '400000', '', '300000', '', '100000', '0', '1500000', '', 'TERJUAL'),
(5, 'M005', 'T 2345 XXX', 'YAMAHA', '2011', 'VIXION', 'ROAD BIKE', '12000000', '123333', '', '44444455', '', '4443242', '0', '3456644', '', 'TERJUAL'),
(7, 'M006', 'B 8970 MKS', 'YAMAHA', '2010', 'JUPITER MX', 'BEBEK', '1200000', '250000', '', '200000', '', '150000', '0', '2000000', '', 'TERJUAL'),
(8, 'M008', 'wwww', 'wwwww', 'eeee', 'eeee', 'MATIC', '2222', '2222', '', '3333', '', '333', '0', '2000000', '', 'TERJUAL'),
(9, 'M009', 'B 3290 nbj', 'YAMAHAHH', '2012', 'rrrrrrr', 'MATIC', '3.333333333333333e23', '3.3333333333333333e24', '', '3.333333333333333e23', '', '3.333333333333333e23', '0', '2000000', '', 'READY'),
(10, 'M0010', 'B 9899 knm', 'HONDA', '2010', 'VARIO', 'MATIC', '12000000', '2111111', '', '2111199', '', '1111111', '0', '2000000', '', 'TERJUAL'),
(11, 'M0011', 'B 3200 BKS', 'SUZUKI', '2010', 'SATRIA', 'SPORT', '15000000', '1252727,27', '', '633043,48', '', '438285,71', '0', '2000000', '', 'TERJUAL'),
(12, 'M0012', 'b 2345 ggg', 'YAMAHA', '2010', 'mio', 'MATIC', '10000000', '770909,091', '43636,364', '389565,217', '41739,13', '269714,286', '41142,857', '2000000', '6', 'TERJUAL'),
(13, 'M0013', 'b 2345 tgg', 'YAMAHA', '2010', 'jupite', 'MATIC', '15000000', '1252700', '70909,091', '633100', '67826,087', '438300', '66857,143', '2000000', '6', 'TERJUAL');

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_pembeli`
--

CREATE TABLE IF NOT EXISTS `data_pembeli` (
  `id` int(225) NOT NULL AUTO_INCREMENT,
  `xnopem` varchar(50) NOT NULL,
  `xnama` varchar(30) NOT NULL,
  `xno_iden` varchar(20) NOT NULL,
  `x_alamat` varchar(30) NOT NULL,
  `x_nohp` varchar(15) NOT NULL,
  `xtgl_beli` varchar(10) NOT NULL,
  `xkode_mtr` varchar(225) NOT NULL,
  `xharga` varchar(100) NOT NULL,
  `xdp` varchar(50) NOT NULL,
  `xkredit` varchar(100) NOT NULL,
  `xbunga` varchar(50) NOT NULL,
  `xangsuran` varchar(20) NOT NULL,
  `xangke` varchar(5) NOT NULL,
  `xsisa` varchar(10) NOT NULL,
  `xket` varchar(30) NOT NULL,
  `xketerangan` varchar(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `xno_pem` (`xnopem`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data untuk tabel `data_pembeli`
--

INSERT INTO `data_pembeli` (`id`, `xnopem`, `xnama`, `xno_iden`, `x_alamat`, `x_nohp`, `xtgl_beli`, `xkode_mtr`, `xharga`, `xdp`, `xkredit`, `xbunga`, `xangsuran`, `xangke`, `xsisa`, `xket`, `xketerangan`) VALUES
(1, 'P001', 'dddadadad', '313141414', 'dfsfsf', '31414143434', '02-12-2016', 'M003', '15000000', '', '', '', '6X', '', '6', '15000000', ''),
(2, 'P002', 'AINNURDIN', '128818881', 'PAPUA', '089777277727', '02-12-2016', 'M008', '18000000', '', '', '', '12x', '', '12', '18000000', ''),
(3, 'P003', 'AIN', '322332221', 'PAPUA', '08777888999', '02-12-2016', 'M008', '18000000', '', '200000', '', '12x', '1', '11', '16000000', 'BELUM LUNAS'),
(4, 'P004', 'RAMBET', '9882881800', 'KOSAMBI', '085765677788', '03-12-2016', 'M006', '20000000', '', '200000', '', '9X', '5', '5', '17400000', 'LUNAS'),
(5, 'P005', 'GOONG', '828828282828222', 'LAMARAN', '085624451551', '11-12-2016', 'M0011', '15000000', '', '633043,48', '', 'ANSGURAN 23X', '0', '24', '15000000', 'BELUM LUNAS'),
(6, 'P006', 'abi', '2222', 'kkkk', '3333', '11-12-2016', 'M0010', '12000000', '2000000', '2111111', '47667', 'ANGSURAN 11X', '10', '0', '-6444108.0', 'LUNAS'),
(7, 'P007', 'aaa', '3', 'fff', '3', '11-12-2016', 'M0012', '10000000', '2000000', '770909.19', '43636,364', 'ANGSURAN 11X', '1', '7', '0', 'BELUM LUNAS'),
(8, 'P008', 'anu', '1111', 'llala', '2222', '12-12-2016', 'M008', '2222', '2000000', '333', '0', 'ANGSURAN 35x', '0', '36', '2222', 'BELUM LUNAS'),
(9, 'P009', 'sdd', '34333', 'fffff', '2133kk', '12-12-2016', 'M0013', '15000000', '2000000', '1000000', '100000', 'ANGSURAN 35x', '10', '26', '9100000.0', 'BELUM LUNAS');

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_terjual`
--

CREATE TABLE IF NOT EXISTS `data_terjual` (
  `id` int(225) NOT NULL AUTO_INCREMENT,
  `nkode` varchar(1000) NOT NULL,
  `nnopol` varchar(10) NOT NULL,
  `nmerek` varchar(10) NOT NULL,
  `ntype` varchar(30) NOT NULL,
  `ntahun` varchar(4) NOT NULL,
  `njenis` varchar(10) NOT NULL,
  `nharga` varchar(30) NOT NULL,
  `na_11x` varchar(30) NOT NULL,
  `na_23x` varchar(30) NOT NULL,
  `na_35x` varchar(30) NOT NULL,
  `ndp` varchar(20) NOT NULL,
  `nketerangan` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=29 ;

--
-- Dumping data untuk tabel `data_terjual`
--

INSERT INTO `data_terjual` (`id`, `nkode`, `nnopol`, `nmerek`, `ntype`, `ntahun`, `njenis`, `nharga`, `na_11x`, `na_23x`, `na_35x`, `ndp`, `nketerangan`) VALUES
(1, 'M001', 'B 123 BF', 'YAMAHA', 'JUPITER MX', '2010', 'SPORT', '10000000', '11111', '22222', '33333', '54444', 'TERJUAL'),
(2, 'M002', 'T 8788 MKS', 'YAMAHA', 'JUPITER MX', '2010', 'BEBEK', '8000000', '100000', '200000', '30000', '1000000', 'TERJUAL'),
(3, 'M003', 'T 2017 XXX', 'SUZUKI', 'SATRIA', '2014', 'SPORT', '15000000', '122222', '133333', '22222', '100000', 'TERJUAL'),
(4, 'M004', 'B 1021 KKN', 'HONDA', 'MIO', '2010', 'BEBEK', '8000000', '400000', '300000', '100000', '1500000', 'TERJUAL'),
(20, 'M008', 'B 7899 KTP', 'HONDA', 'CBR', '2012', 'SPORT', '18000000', '1988888', '2222229', '1111118', '20000000', 'TERJUAL'),
(24, 'M006', 'B 8970 MKS', 'YAMAHA', 'JUPITER MX', '2010', 'BEBEK', '1200000', '250000', '200000', '150000', '2000000', 'TERJUAL'),
(25, 'M0010', 'B 9899 knm', 'HONDA', 'VARIO', '2010', 'MATIC', '12000000', '2111111', '2111199', '1111111', '2000000', 'TERJUAL'),
(26, 'M0012', 'b 2345 ggg', 'YAMAHA', 'mio', '2010', 'MATIC', '10000000', '770909,091', '389565,217', '269714,286', '2000000', 'TERJUAL'),
(27, 'M008', 'wwww', 'wwwww', 'eeee', 'eeee', 'MATIC', '2222', '2222', '3333', '333', '2000000', 'TERJUAL'),
(28, 'M0013', 'b 2345 tgg', 'YAMAHA', 'jupite', '2010', 'MATIC', '15000000', '1252700', '633100', '438300', '2000000', 'TERJUAL');

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_transaksi`
--

CREATE TABLE IF NOT EXISTS `data_transaksi` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `ttgl` varchar(10) NOT NULL,
  `tnopem` varchar(20) NOT NULL,
  `tnama` varchar(30) NOT NULL,
  `tnomtr` varchar(10) NOT NULL,
  `tpembayaran` varchar(50) NOT NULL,
  `tnominal` varchar(50) NOT NULL,
  `tbunga` varchar(50) NOT NULL,
  `tdenda` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=35 ;

--
-- Dumping data untuk tabel `data_transaksi`
--

INSERT INTO `data_transaksi` (`id`, `ttgl`, `tnopem`, `tnama`, `tnomtr`, `tpembayaran`, `tnominal`, `tbunga`, `tdenda`) VALUES
(2, '10-12-2016', 'P004', 'RAMBET', 'M006', '', '', '', '400.0'),
(3, '10-12-2016', 'P004', 'RAMBET', 'M006', 'Angsuran Ke-3', '200000', '', '400.0'),
(4, '10-12-2016', 'P004', 'RAMBET', 'M006', '', '', '', '400.0'),
(5, '10-12-2016', 'P004', 'RAMBET', 'M006', 'Angsuran Ke-4', '200000', '', '400.0'),
(6, '11-12-2016', 'P006', 'abi', 'M0010', 'UANG MUKA', '2000000', '', ''),
(7, '11-12-2016', 'P007', 'aaa', 'M0012', 'UANG MUKA', '2000000', '0', ''),
(8, '11-12-2016', 'P007', 'aaa', 'M0012', '', '', '', ''),
(9, '11-12-2016', 'P007', 'aaa', 'M0012', '', '', '', ''),
(10, '11-12-2016', 'P006', 'abi', 'M0010', 'Angsuran Ke-1', '2111111', '47667', ''),
(11, '11-12-2016', 'P006', 'abi', 'M0010', 'Angsuran Ke-2', '2111111', '47667', ''),
(12, '11-12-2016', 'P006', 'abi', 'M0010', '', '', '', ''),
(13, '11-12-2016', 'P006', 'abi', 'M0010', 'Angsuran Ke-2', '2111111', '47667', ''),
(14, '11-12-2016', 'P006', 'abi', 'M0010', 'Angsuran Ke-3', '2111111', '47667', ''),
(15, '11-12-2016', 'P006', 'abi', 'M0010', 'Angsuran Ke-4', '2111111', '47667', ''),
(16, '11-12-2016', 'P006', 'abi', 'M0010', 'Angsuran Ke-5', '2111111', '47667', ''),
(17, '11-12-2016', 'P006', 'abi', 'M0010', 'Angsuran Ke-6', '2111111', '47667', ''),
(18, '11-12-2016', 'P006', 'abi', 'M0010', 'Angsuran Ke-7', '2111111', '47667', ''),
(19, '11-12-2016', 'P006', 'abi', 'M0010', 'Angsuran Ke-7', '2111111', '47667', ''),
(20, '11-12-2016', 'P006', 'abi', 'M0010', 'Angsuran Ke-8', '2111111', '47667', ''),
(21, '11-12-2016', 'P007', 'aaa', 'M0012', 'UANG MUKA', '2000000', '0', ''),
(22, '12-12-2016', 'P006', 'abi', 'M0010', 'Angsuran Ke-9', '2111111', '47667', ''),
(23, '12-12-2016', 'P009', 'sdd', 'M0013', 'UANG MUKA', '2000000', '0', ''),
(24, '12-12-2016', 'P009', 'sdd', 'M0013', 'Angsuran Ke-1', '438300', '66857.143', ''),
(25, '12-12-2016', 'P009', 'sdd', 'M0013', 'Angsuran Ke-1', '438300', '66857.143', ''),
(26, '12-12-2016', 'P009', 'sdd', 'M0013', 'Angsuran Ke-1', '438300', '66857.143', ''),
(27, '12-12-2016', 'P009', 'sdd', 'M0013', 'Angsuran Ke-2', '438300', '66857.143', ''),
(28, '12-12-2016', 'P009', 'sdd', 'M0013', 'Angsuran Ke-3', '438300', '66857.143', ''),
(29, '12-12-2016', 'P009', 'sdd', 'M0013', 'Angsuran Ke-4', '438300', '66857.143', ''),
(30, '12-12-2016', 'P009', 'sdd', 'M0013', 'Angsuran Ke-5', '438300', '66857.143', ''),
(31, '12-12-2016', 'P009', 'sdd', 'M0013', 'Angsuran Ke-6', '20000', '5000', ''),
(32, '12-12-2016', 'P009', 'sdd', 'M0013', 'Angsuran Ke-7', '20000', '5000', ''),
(33, '12-12-2016', 'P009', 'sdd', 'M0013', 'Angsuran Ke-8', '20000', '5000', ''),
(34, '12-12-2016', 'P009', 'sdd', 'M0013', 'Angsuran Ke-9', '1000000', '100000', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `no_angsuran`
--

CREATE TABLE IF NOT EXISTS `no_angsuran` (
  `angsuran` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `no_angsuran`
--

INSERT INTO `no_angsuran` (`angsuran`) VALUES
('1'),
('2'),
('3'),
('4'),
('5'),
('6'),
('7'),
('8'),
('9'),
('10'),
('11'),
('12'),
('13'),
('14'),
('15'),
('16'),
('17'),
('18'),
('19'),
('10'),
('21'),
('22'),
('23'),
('24'),
('25'),
('26'),
('27'),
('28'),
('29'),
('30'),
('31'),
('32'),
('33'),
('34'),
('35');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
