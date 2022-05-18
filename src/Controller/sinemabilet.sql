-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Ãretim ZamanÄ±: 05 May 2022, 20:09:52
-- Sunucu sÃ¼rÃ¼mÃ¼: 10.4.24-MariaDB
-- PHP SÃ¼rÃ¼mÃ¼: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- VeritabanÄ±: `sinemabilet`
--

-- --------------------------------------------------------

--
-- Tablo iÃ§in tablo yapÄ±sÄ± `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo iÃ§in tablo yapÄ±sÄ± `film`
--

CREATE TABLE `film` (
  `FilmId` int(11) NOT NULL,
  `FilmAdi` varchar(75) NOT NULL,
  `FilmTur` varchar(25) NOT NULL,
  `GÃ¶rsel` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo iÃ§in tablo yapÄ±sÄ± `misafir`
--

CREATE TABLE `misafir` (
  `GuestId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo iÃ§in tablo yapÄ±sÄ± `mÃ¼steri`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `ad` varchar(25) NOT NULL,
  `soyad` varchar(25) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `mail` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo iÃ§in tablo yapÄ±sÄ± `odeme`
--

CREATE TABLE `odeme` (
  `OdemeId` int(11) NOT NULL,
  `RezervasyonId` int(11) NOT NULL,
  `Fiyat` int(11) NOT NULL,
  `OdemeTarih` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo iÃ§in tablo yapÄ±sÄ± `rezervasyon`
--

CREATE TABLE `rezervasyon` (
  `RezervasyonId` int(11) NOT NULL,
  `UserName` varchar(25) NOT NULL,
  `RezervasyonTarih` datetime NOT NULL,
  `FilmAdi` varchar(75) NOT NULL,
  `KoltukNumara` int(11) NOT NULL,
  `SalonAdi` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo iÃ§in tablo yapÄ±sÄ± `salon`
--

CREATE TABLE `salon` (
  `SalonId` int(11) NOT NULL,
  `SalonAdÄ±` varchar(10) NOT NULL,
  `KoltukId` int(11) NOT NULL,
  `KoltukNumara` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo iÃ§in tablo yapÄ±sÄ± `seans`
--

CREATE TABLE `seans` (
  `SeansId` int(11) NOT NULL,
  `Saat` time NOT NULL,
  `Tarih` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- DÃ¶kÃ¼mÃ¼ yapÄ±lmÄ±Å tablolar iÃ§in indeksler
--

--
-- Tablo iÃ§in indeksler `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Tablo iÃ§in indeksler `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`FilmId`),
  ADD KEY `FilmAdi` (`FilmAdi`);

--
-- Tablo iÃ§in indeksler `misafir`
--
ALTER TABLE `misafir`
  ADD PRIMARY KEY (`GuestId`);

--
-- Tablo iÃ§in indeksler `mÃ¼steri`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`);

--
-- Tablo iÃ§in indeksler `odeme`
--
ALTER TABLE `odeme`
  ADD PRIMARY KEY (`OdemeId`),
  ADD KEY `RezervasyonId` (`RezervasyonId`);

--
-- Tablo iÃ§in indeksler `rezervasyon`
--
ALTER TABLE `rezervasyon`
  ADD PRIMARY KEY (`RezervasyonId`),
  ADD KEY `UserName` (`UserName`,`FilmAdi`,`KoltukNumara`,`SalonAdi`),
  ADD KEY `FilmAdi` (`FilmAdi`),
  ADD KEY `SalonAdi` (`SalonAdi`),
  ADD KEY `KoltukNumara` (`KoltukNumara`);

--
-- Tablo iÃ§in indeksler `salon`
--
ALTER TABLE `salon`
  ADD PRIMARY KEY (`SalonId`),
  ADD KEY `SalonAdÄ±` (`SalonAdÄ±`,`KoltukNumara`),
  ADD KEY `KoltukNumara` (`KoltukNumara`);

--
-- Tablo iÃ§in indeksler `seans`
--
ALTER TABLE `seans`
  ADD PRIMARY KEY (`SeansId`);

--
-- DÃ¶kÃ¼mÃ¼ yapÄ±lmÄ±Å tablolar iÃ§in AUTO_INCREMENT deÄeri
--

--
-- Tablo iÃ§in AUTO_INCREMENT deÄeri `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo iÃ§in AUTO_INCREMENT deÄeri `film`
--
ALTER TABLE `film`
  MODIFY `FilmId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo iÃ§in AUTO_INCREMENT deÄeri `misafir`
--
ALTER TABLE `misafir`
  MODIFY `GuestId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo iÃ§in AUTO_INCREMENT deÄeri `mÃ¼steri`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo iÃ§in AUTO_INCREMENT deÄeri `odeme`
--
ALTER TABLE `odeme`
  MODIFY `OdemeId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo iÃ§in AUTO_INCREMENT deÄeri `rezervasyon`
--
ALTER TABLE `rezervasyon`
  MODIFY `RezervasyonId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo iÃ§in AUTO_INCREMENT deÄeri `salon`
--
ALTER TABLE `salon`
  MODIFY `SalonId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo iÃ§in AUTO_INCREMENT deÄeri `seans`
--
ALTER TABLE `seans`
  MODIFY `SeansId` int(11) NOT NULL AUTO_INCREMENT;

--
-- DÃ¶kÃ¼mÃ¼ yapÄ±lmÄ±Å tablolar iÃ§in kÄ±sÄ±tlamalar
--

--
-- Tablo kÄ±sÄ±tlamalarÄ± `odeme`
--
ALTER TABLE `odeme`
  ADD CONSTRAINT `odeme_ibfk_1` FOREIGN KEY (`RezervasyonId`) REFERENCES `rezervasyon` (`RezervasyonId`);

--
-- Tablo kÄ±sÄ±tlamalarÄ± `rezervasyon`
--
ALTER TABLE `rezervasyon`
  ADD CONSTRAINT `rezervasyon_ibfk_1` FOREIGN KEY (`FilmAdi`) REFERENCES `film` (`FilmAdi`),
  ADD CONSTRAINT `rezervasyon_ibfk_2` FOREIGN KEY (`username`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `rezervasyon_ibfk_3` FOREIGN KEY (`SalonAdi`) REFERENCES `salon` (`SalonAdÄ±`),
  ADD CONSTRAINT `rezervasyon_ibfk_4` FOREIGN KEY (`KoltukNumara`) REFERENCES `salon` (`KoltukNumara`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
