-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 19 Jan 2020 pada 00.38
-- Versi server: 10.1.37-MariaDB
-- Versi PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_penduduk`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tiuran`
--

CREATE TABLE `tiuran` (
  `kode_t` int(11) NOT NULL,
  `tagihan` int(11) NOT NULL,
  `nik` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tiuran`
--

INSERT INTO `tiuran` (`kode_t`, `tagihan`, `nik`) VALUES
(1, 10000, '3215252612680001'),
(2, 20000, '3215255101690002');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tlogin`
--

CREATE TABLE `tlogin` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tlogin`
--

INSERT INTO `tlogin` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tpenduduk`
--

CREATE TABLE `tpenduduk` (
  `id` int(11) NOT NULL,
  `nik` varchar(30) NOT NULL,
  `namapen` varchar(30) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `tempat_lahir` varchar(30) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `agama` varchar(30) NOT NULL,
  `pendidikan` varchar(30) NOT NULL,
  `jenis_pekerjaan` varchar(30) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `jenis_penduduk` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tpenduduk`
--

INSERT INTO `tpenduduk` (`id`, `nik`, `namapen`, `jenis_kelamin`, `tempat_lahir`, `tanggal_lahir`, `agama`, `pendidikan`, `jenis_pekerjaan`, `alamat`, `jenis_penduduk`) VALUES
(1, '3215252612680001', 'KUSWANTO', 'LAKI-LAKI', 'KEDIRI', '1966-12-26', 'ISLAM', 'DIPLOMA IV/STRATA I', 'KARYAWAN SWASTA', 'PERUM EKAMAS BLOK AK - 37', 'TETAP'),
(2, '3215255101690002', 'TATYK  SUPRAPTY.SE', 'PEREMPUAN', 'MAKASAR', '1969-01-11', 'ISLAM', 'DIPLOMA IV/ STRATA I', 'MENGURUS RUMAH TANGGA', 'PERUM EKAMAS BLOK AK-37', 'TETAP'),
(7, '1023k', 'jdasn', 'adkj', 'dqwkj', '2000-01-01', 'kdj', 'sdknq', 'jkdsn', 'ksalmdas', 'SEMENTARA'),
(8, 'ijdsaidj', 'iajdqwdq', 'dqjiw', 'jdqwi', '2009-01-01', 'iqwjdw', 'idsaji', 'idjqwi', 'asasca', 'KONTRAK'),
(9, 'djqnw', 'iquwdn', 'sajidn', 'qwjnd', '2005-01-01', 'iquwdn', 'qwudn', 'ijdsan', 'masdomqw', 'LAINNYA');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tstatus`
--

CREATE TABLE `tstatus` (
  `kodestat` int(11) NOT NULL,
  `nik` varchar(30) NOT NULL,
  `status_perkawinan` varchar(30) NOT NULL,
  `hubungan_keluarga` varchar(30) NOT NULL,
  `kewarganegaraan` varchar(30) NOT NULL,
  `dokumen_imigrasi` varchar(30) NOT NULL,
  `nama_ayah` varchar(30) NOT NULL,
  `nama_ibu` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tstatus`
--

INSERT INTO `tstatus` (`kodestat`, `nik`, `status_perkawinan`, `hubungan_keluarga`, `kewarganegaraan`, `dokumen_imigrasi`, `nama_ayah`, `nama_ibu`) VALUES
(1, '3215252612680001', 'KAWIN', 'KEPALA KELUARGA', 'INDONESIA', '-', 'H. HARJO SUSANTO', 'KARTI'),
(2, '3215255101690002', 'KAWIN', 'ISTRI', 'INDONESIA', '-', 'M.SUNARYO', 'R.RUSMINI'),
(7, '1023k', 'asd', 'KEPALA KELUARGA', 'adas', 'asd', 'ads', 'dsa');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tiuran`
--
ALTER TABLE `tiuran`
  ADD PRIMARY KEY (`kode_t`),
  ADD KEY `nik` (`nik`);

--
-- Indeks untuk tabel `tlogin`
--
ALTER TABLE `tlogin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indeks untuk tabel `tpenduduk`
--
ALTER TABLE `tpenduduk`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nik` (`nik`);

--
-- Indeks untuk tabel `tstatus`
--
ALTER TABLE `tstatus`
  ADD PRIMARY KEY (`kodestat`),
  ADD KEY `nik` (`nik`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tiuran`
--
ALTER TABLE `tiuran`
  MODIFY `kode_t` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT untuk tabel `tlogin`
--
ALTER TABLE `tlogin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `tpenduduk`
--
ALTER TABLE `tpenduduk`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT untuk tabel `tstatus`
--
ALTER TABLE `tstatus`
  MODIFY `kodestat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tstatus`
--
ALTER TABLE `tstatus`
  ADD CONSTRAINT `tstatus_ibfk_1` FOREIGN KEY (`nik`) REFERENCES `tpenduduk` (`nik`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
