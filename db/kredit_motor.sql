-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Inang: 127.0.0.1
-- Waktu pembuatan: 02 Des 2016 pada 15.01
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
-- Struktur dari tabel `data_motor`
--

CREATE TABLE IF NOT EXISTS `data_motor` (
  `id` int(225) NOT NULL AUTO_INCREMENT,
  `mkode` varchar(100) NOT NULL,
  `mnopol` varchar(10) NOT NULL,
  `mmerek` varchar(10) NOT NULL,
  `mtahun` varchar(4) NOT NULL,
  `mtype` varchar(10) NOT NULL,
  `mjenis` varchar(10) NOT NULL,
  `mharga` double NOT NULL,
  `ma_6x` double NOT NULL,
  `ma_9x` double NOT NULL,
  `ma_12x` double NOT NULL,
  `mdp` varchar(20) NOT NULL,
  `mketerangan` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mkode` (`mkode`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data untuk tabel `data_motor`
--

INSERT INTO `data_motor` (`id`, `mkode`, `mnopol`, `mmerek`, `mtahun`, `mtype`, `mjenis`, `mharga`, `ma_6x`, `ma_9x`, `ma_12x`, `mdp`, `mketerangan`) VALUES
(1, 'M001', 'B 360 BGT', 'HONDA', '2012', 'MEGA PRO', 'ROAD BIKE', 1200000, 11111, 22222, 33333, '200000000', 'TERJUAL'),
(2, 'M002', 'T 8788 MKS', 'YAMAHA', '2010', 'JUPITER MX', 'BEBEK', 8000000, 100000, 200000, 30000, '1000000', 'TERJUAL'),
(3, 'M003', 'T 2017 XXX', 'SUZUKI', '2014', 'SATRIA', 'SPORT', 15000000, 122222, 133333, 22222, '100000', 'TERJUAL'),
(4, 'M004', 'B 1021 KKN', 'HONDA', '2010', 'MIO', 'BEBEK', 8000000, 400000, 300000, 100000, '1500000', 'TERJUAL'),
(6, 'M005', 'T 2345 XXX', 'YAMAHA', '2011', 'VIXION', 'ROAD BIKE', 12000000, 123333, 44444455, 4443242, '3456644', 'TERJUAL');

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_pembeli`
--

CREATE TABLE IF NOT EXISTS `data_pembeli` (
  `id` int(225) NOT NULL AUTO_INCREMENT,
  `xnopem` varchar(100) NOT NULL,
  `xnama` varchar(30) NOT NULL,
  `xno_iden` varchar(20) NOT NULL,
  `x_alamat` varchar(30) NOT NULL,
  `x_nohp` varchar(15) NOT NULL,
  `xtgl_beli` varchar(10) NOT NULL,
  `xkode_mtr` varchar(225) NOT NULL,
  `xharga` varchar(100) NOT NULL,
  `xkredit` varchar(100) NOT NULL,
  `xangsuran` varchar(5) NOT NULL,
  `xsisa` varchar(10) NOT NULL,
  `xket` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `xno_pem` (`xnopem`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data untuk tabel `data_pembeli`
--

INSERT INTO `data_pembeli` (`id`, `xnopem`, `xnama`, `xno_iden`, `x_alamat`, `x_nohp`, `xtgl_beli`, `xkode_mtr`, `xharga`, `xkredit`, `xangsuran`, `xsisa`, `xket`) VALUES
(1, 'P001', 'dddadadad', '313141414', 'dfsfsf', '31414143434', '02-12-2016', 'M003', '15000000', '', '6X', '6', '15000000'),
(2, 'P002', 'AINNURDIN', '128818881', 'PAPUA', '089777277727', '02-12-2016', 'M008', '18000000', '', '12x', '12', '18000000'),
(3, 'P003', 'AIN', '322332221', 'PAPUA', '08777888999', '02-12-2016', 'M008', '18000000', '', '12x', '12', '18000000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_terjual`
--

CREATE TABLE IF NOT EXISTS `data_terjual` (
  `id` int(225) NOT NULL AUTO_INCREMENT,
  `nkode` varchar(1000) NOT NULL,
  `nnopol` varchar(10) NOT NULL,
  `nmerek` varchar(10) NOT NULL,
  `ntype` varchar(20) NOT NULL,
  `ntahun` varchar(4) NOT NULL,
  `njenis` varchar(10) NOT NULL,
  `nharga` double NOT NULL,
  `na_6x` double NOT NULL,
  `na_9x` double NOT NULL,
  `na_12x` double NOT NULL,
  `ndp` varchar(20) NOT NULL,
  `nketerangan` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dumping data untuk tabel `data_terjual`
--

INSERT INTO `data_terjual` (`id`, `nkode`, `nnopol`, `nmerek`, `ntype`, `ntahun`, `njenis`, `nharga`, `na_6x`, `na_9x`, `na_12x`, `ndp`, `nketerangan`) VALUES
(1, 'M001', 'B 123 BF', 'YAMAHA', 'JUPITER MX', '2010', 'SPORT', 10000000, 11111, 22222, 33333, '54444', 'TERJUAL'),
(2, 'M002', 'T 8788 MKS', 'YAMAHA', 'JUPITER MX', '2010', 'BEBEK', 8000000, 100000, 200000, 30000, '1000000', 'TERJUAL'),
(3, 'M003', 'T 2017 XXX', 'SUZUKI', 'SATRIA', '2014', 'SPORT', 15000000, 122222, 133333, 22222, '100000', 'TERJUAL'),
(4, 'M004', 'B 1021 KKN', 'HONDA', 'MIO', '2010', 'BEBEK', 8000000, 400000, 300000, 100000, '1500000', 'TERJUAL'),
(15, 'M005', 'T 2345 XXX', 'YAMAHA', 'VIXION', '2011', 'ROAD BIKE', 12000000, 123333, 44444455, 4443242, '3456644', 'TERJUAL'),
(16, 'M001', 'B 360 BGT', 'HONDA', 'MEGA PRO', '2012', 'ROAD BIKE', 1200000, 11111, 22222, 33333, '200000000', 'TERJUAL'),
(17, 'M002', 'T 8788 MKS', 'YAMAHA', 'JUPITER MX', '2010', 'BEBEK', 8000000, 100000, 200000, 30000, '1000000', 'TERJUAL'),
(18, 'M002', 'T 8788 MKS', 'YAMAHA', 'JUPITER MX', '2010', 'BEBEK', 8000000, 100000, 200000, 30000, '1000000', 'TERJUAL'),
(19, 'M003', 'T 2017 XXX', 'SUZUKI', 'SATRIA', '2014', 'SPORT', 15000000, 122222, 133333, 22222, '100000', 'TERJUAL'),
(20, 'M008', 'B 7899 KTP', 'HONDA', 'CBR', '2012', 'SPORT', 18000000, 1988888, 2222229, 1111118, '20000000', 'TERJUAL'),
(21, 'M008', 'B 7899 KTP', 'HONDA', 'CBR', '2012', 'SPORT', 18000000, 1988888, 2222229, 1111118, '20000000', 'TERJUAL'),
(22, 'M008', 'B 7899 KTP', 'HONDA', 'CBR', '2012', 'SPORT', 18000000, 1988888, 2222229, 1111118, '20000000', 'TERJUAL'),
(23, 'M007', 'B 8799 MKS', 'HONDA', 'CBR', '2012', 'SPO', 0, 0, 0, 0, '', 'TERJUAL');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
