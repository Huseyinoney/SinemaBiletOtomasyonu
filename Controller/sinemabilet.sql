-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 16 May 2022, 12:41:56
-- Sunucu sürümü: 10.4.24-MariaDB
-- PHP Sürümü: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `sinemabilet`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `admin`
--

CREATE TABLE `admin` (
  `AdminId` int(11) NOT NULL,
  `UserName` varchar(25) NOT NULL,
  `Password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `film`
--

CREATE TABLE `film` (
  `FilmId` int(11) NOT NULL,
  `FilmAdi` varchar(75) NOT NULL,
  `FilmTur` varchar(25) NOT NULL,
  `Görsel` blob NOT NULL,
  `FilmTarih` varchar(25) NOT NULL,
  `FilmSaat` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `misafir`
--

CREATE TABLE `misafir` (
  `GuestId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `müsteri`
--

CREATE TABLE `müsteri` (
  `CustomerId` int(11) NOT NULL,
  `UserName` varchar(25) NOT NULL,
  `Password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `odeme`
--

CREATE TABLE `odeme` (
  `OdemeId` int(11) NOT NULL,
  `RezervasyonId` int(11) NOT NULL,
  `Fiyat` int(11) NOT NULL,
  `OdemeTarih` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `rezervasyon`
--

CREATE TABLE `rezervasyon` (
  `RezervasyonId` int(11) NOT NULL,
  `UserName` varchar(25) NOT NULL,
  `RezervasyonTarih` varchar(25) NOT NULL,
  `FilmAdi` varchar(75) NOT NULL,
  `KoltukNumara` int(11) NOT NULL,
  `SalonAdi` varchar(10) NOT NULL,
  `FilmTarih` varchar(25) NOT NULL,
  `FilmSaat` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `salon`
--

CREATE TABLE `salon` (
  `SalonId` int(11) NOT NULL,
  `SalonAdı` varchar(10) NOT NULL,
  `KoltukId` int(11) NOT NULL,
  `KoltukNumara` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `seans`
--

CREATE TABLE `seans` (
  `SeansId` int(11) NOT NULL,
  `SeansSaat` varchar(25) NOT NULL,
  `SeansTarih` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`AdminId`);

--
-- Tablo için indeksler `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`FilmId`),
  ADD KEY `FilmAdi` (`FilmAdi`),
  ADD KEY `FilmTarih` (`FilmTarih`,`FilmSaat`),
  ADD KEY `FilmSaat` (`FilmSaat`);

--
-- Tablo için indeksler `misafir`
--
ALTER TABLE `misafir`
  ADD PRIMARY KEY (`GuestId`);

--
-- Tablo için indeksler `müsteri`
--
ALTER TABLE `müsteri`
  ADD PRIMARY KEY (`CustomerId`),
  ADD KEY `UserName` (`UserName`);

--
-- Tablo için indeksler `odeme`
--
ALTER TABLE `odeme`
  ADD PRIMARY KEY (`OdemeId`),
  ADD KEY `RezervasyonId` (`RezervasyonId`),
  ADD KEY `OdemeTarih` (`OdemeTarih`);

--
-- Tablo için indeksler `rezervasyon`
--
ALTER TABLE `rezervasyon`
  ADD PRIMARY KEY (`RezervasyonId`),
  ADD KEY `UserName` (`UserName`,`FilmAdi`,`KoltukNumara`,`SalonAdi`),
  ADD KEY `FilmAdi` (`FilmAdi`),
  ADD KEY `SalonAdi` (`SalonAdi`),
  ADD KEY `KoltukNumara` (`KoltukNumara`),
  ADD KEY `FilmTarih` (`FilmTarih`,`FilmSaat`),
  ADD KEY `FilmSaat` (`FilmSaat`);

--
-- Tablo için indeksler `salon`
--
ALTER TABLE `salon`
  ADD PRIMARY KEY (`SalonId`),
  ADD KEY `SalonAdı` (`SalonAdı`,`KoltukNumara`),
  ADD KEY `KoltukNumara` (`KoltukNumara`);

--
-- Tablo için indeksler `seans`
--
ALTER TABLE `seans`
  ADD PRIMARY KEY (`SeansId`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `admin`
--
ALTER TABLE `admin`
  MODIFY `AdminId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `film`
--
ALTER TABLE `film`
  MODIFY `FilmId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `misafir`
--
ALTER TABLE `misafir`
  MODIFY `GuestId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `müsteri`
--
ALTER TABLE `müsteri`
  MODIFY `CustomerId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `odeme`
--
ALTER TABLE `odeme`
  MODIFY `OdemeId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `rezervasyon`
--
ALTER TABLE `rezervasyon`
  MODIFY `RezervasyonId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `salon`
--
ALTER TABLE `salon`
  MODIFY `SalonId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `seans`
--
ALTER TABLE `seans`
  MODIFY `SeansId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `odeme`
--
ALTER TABLE `odeme`
  ADD CONSTRAINT `odeme_ibfk_1` FOREIGN KEY (`RezervasyonId`) REFERENCES `rezervasyon` (`RezervasyonId`);

--
-- Tablo kısıtlamaları `rezervasyon`
--
ALTER TABLE `rezervasyon`
  ADD CONSTRAINT `rezervasyon_ibfk_1` FOREIGN KEY (`FilmAdi`) REFERENCES `film` (`FilmAdi`),
  ADD CONSTRAINT `rezervasyon_ibfk_2` FOREIGN KEY (`UserName`) REFERENCES `müsteri` (`UserName`),
  ADD CONSTRAINT `rezervasyon_ibfk_3` FOREIGN KEY (`SalonAdi`) REFERENCES `salon` (`SalonAdı`),
  ADD CONSTRAINT `rezervasyon_ibfk_4` FOREIGN KEY (`KoltukNumara`) REFERENCES `salon` (`KoltukNumara`),
  ADD CONSTRAINT `rezervasyon_ibfk_5` FOREIGN KEY (`FilmTarih`) REFERENCES `film` (`FilmTarih`),
  ADD CONSTRAINT `rezervasyon_ibfk_6` FOREIGN KEY (`FilmSaat`) REFERENCES `film` (`FilmSaat`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
