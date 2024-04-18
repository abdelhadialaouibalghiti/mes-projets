-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : dim. 16 avr. 2023 à 11:51
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ecebooking`
--

-- --------------------------------------------------------

--
-- Structure de la table `avis`
--

DROP TABLE IF EXISTS `avis`;
CREATE TABLE IF NOT EXISTS `avis` (
  `Id_CR` int(11) NOT NULL,
  `Id_H` int(11) NOT NULL,
  `Note` decimal(11,2) NOT NULL,
  `Commentaire` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `clientr`
--

DROP TABLE IF EXISTS `clientr`;
CREATE TABLE IF NOT EXISTS `clientr` (
  `Id_CR` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Mail` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nb_voyages` int(11) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `num_tel` varchar(20) NOT NULL,
  `carte_bleue` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`Mail`),
  UNIQUE KEY `UNIQUE` (`Id_CR`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `clientr`
--

INSERT INTO `clientr` (`Id_CR`, `Name`, `Mail`, `password`, `nb_voyages`, `age`, `num_tel`, `carte_bleue`) VALUES
(1, '', 'encore.test.gmail.com', '', 0, 0, '0', ''),
(14, 'berthetjulie', 'jberthet2014', 'ytre', NULL, 0, '0612173185', NULL),
(2, 'Julie', 'jberthet2014@gmail.com', 'passecur', 0, 21, '1236654789', ''),
(17, 'Jade', 'jdejarmy@gmail.com', 'azerty', NULL, 21, '+33781978578', NULL),
(15, 'jean charles', 'jean@charles.fr', 'charles', NULL, 0, '0666666666', NULL),
(3, '', 'test.gmail.com', '', 0, 0, '0', '');

-- --------------------------------------------------------

--
-- Structure de la table `compteh`
--

DROP TABLE IF EXISTS `compteh`;
CREATE TABLE IF NOT EXISTS `compteh` (
  `Id_CH` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Mail` varchar(25) NOT NULL,
  `password` varchar(255) NOT NULL,
  `num_tel` varchar(15) NOT NULL,
  `nb_heberg` int(11) NOT NULL DEFAULT '1',
  `age` int(11) NOT NULL,
  PRIMARY KEY (`Mail`),
  UNIQUE KEY `Id_CH` (`Id_CH`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compteh`
--

INSERT INTO `compteh` (`Id_CH`, `Name`, `Mail`, `password`, `num_tel`, `nb_heberg`, `age`) VALUES
(1, 'Jade de Jarmy', 'jdejarmy@gmail.com', 'cestmoi', '123654789', 1, 20),
(2, 'Berthet Julie', 'j.berthet@mail.fr', 'papillondu77', '789654123', 1, 21),
(3, '', '', '', '', 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `hébergements`
--

DROP TABLE IF EXISTS `hébergements`;
CREATE TABLE IF NOT EXISTS `hébergements` (
  `Id_H` int(11) NOT NULL AUTO_INCREMENT,
  `Mailproprio` varchar(25) NOT NULL,
  `Photo1` varchar(255) NOT NULL,
  `Photo2` varchar(255) NOT NULL,
  `Titre` varchar(255) NOT NULL,
  `Description` text,
  `Categorie` varchar(255) NOT NULL,
  `Lieu` varchar(255) NOT NULL,
  `Note` decimal(11,2) NOT NULL DEFAULT '5.00',
  `Prix` decimal(11,2) NOT NULL,
  `Capacite` int(11) NOT NULL,
  `nb_chambres` int(11) NOT NULL,
  `nb_occupees` int(11) NOT NULL DEFAULT '0',
  `Piscine` tinyint(1) NOT NULL,
  `Terrasse` tinyint(1) NOT NULL,
  PRIMARY KEY (`Titre`),
  UNIQUE KEY `h_id` (`Id_H`),
  UNIQUE KEY `h_id_2` (`Id_H`),
  UNIQUE KEY `Id_H` (`Id_H`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `hébergements`
--

INSERT INTO `hébergements` (`Id_H`, `Mailproprio`, `Photo1`, `Photo2`, `Titre`, `Description`, `Categorie`, `Lieu`, `Note`, `Prix`, `Capacite`, `nb_chambres`, `nb_occupees`, `Piscine`, `Terrasse`) VALUES
(1, 'zimbaboue', 'images/Photo1_caca', 'images/Photo2_caca', 'caca', '', 'null', 'chez toi', '0.00', '0.00', 2, 0, 0, 1, 1),
(7, 'zimbaboue', 'images/Photo1_dfd', 'images/2_dfdavionnn.jpg', 'dfd', '', 'null', '', '0.00', '0.00', 0, 0, 0, 1, 1),
(2, 'zimbabou', 'images/Photo1_edrftg', 'images/Photo2_edrftg', 'edrftg', '', 'null', 'pi', '0.00', '0.00', 5, 0, 0, 1, 1),
(8, 'zimbaboue', 'images/1_hehe_hms intrepid.jpg', 'images/2_heheA05_storyboard2.jpg', 'hehe', '', 'null', 'chez moi', '0.00', '0.00', 2, 0, 0, 1, 1),
(9, 'zimbaboue', 'images/1_hihi_velib_modeles_2018.jpg', 'images/2_hihiScreenshot 2022-11-23 at 21.22.22.png', 'hihi', '', 'Hôtel', 'o', '0.00', '0.00', 0, 0, 0, 0, 1),
(11, 'zimbaboue', 'images/hihii_1_50ans.png', 'images/hihii_2_360_F_389306425_zAsiEURL3pnvNC3gPotVFrz5whXzMsiB.jpg', 'hihii', '', 'Châlet', 'chez mua', '5.00', '80.00', 2, 1, 0, 1, 0),
(3, 'zimbabou', 'images/Photo1_kijuhygt', 'images/Photo2_kijuhygt', 'kijuhygt', '', 'null', '', '0.00', '0.00', 0, 0, 0, 1, 1),
(5, 'zimbaboue', 'images/Photo1_mama', 'images/Photo2_mama', 'mama', '', 'null', '', '0.00', '0.00', 0, 0, 0, 1, 1),
(6, 'zimbaboue', 'images/Photo1_mpmp', 'images/Photo2_mpmp', 'mpmp', '', 'null', '', '0.00', '0.00', 0, 0, 0, 1, 1),
(4, 'zimbabou', 'images/Photo1_popo', 'images/Photo2_popo', 'popo', '', 'null', '', '0.00', '0.00', 0, 0, 0, 1, 1),
(12, 'j.berthet@mail.fr', 'images/Villa des roses_photo1_Dos or.png', 'images/Villa des roses_photo2_INTER ING3.png', 'Villa des roses', '', 'Châlet', 'Marseille bb', '5.00', '79.00', 2, 5, 0, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
CREATE TABLE IF NOT EXISTS `reservations` (
  `Id_R` int(11) NOT NULL AUTO_INCREMENT,
  `Mailclient` varchar(60) NOT NULL,
  `Nomclient` varchar(60) NOT NULL,
  `DateArrivee` date NOT NULL,
  `DateDepart` date NOT NULL,
  `Id_H` int(11) NOT NULL,
  `Id_CR` int(11) NOT NULL,
  PRIMARY KEY (`Id_R`)
) ENGINE=MyISAM AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reservations`
--

INSERT INTO `reservations` (`Id_R`, `Mailclient`, `Nomclient`, `DateArrivee`, `DateDepart`, `Id_H`, `Id_CR`) VALUES
(1, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(2, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(3, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(4, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(5, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(6, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(7, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(8, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(9, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(10, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(11, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(12, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(13, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(14, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(15, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(16, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(17, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(18, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(19, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(20, 'jberthet2014@gmail.com', 'Julie', '3923-11-05', '3923-11-10', 12, 2),
(21, 'jberthet2014@gmail.com', 'Julie', '1923-11-05', '3923-11-10', 12, 2),
(22, 'jberthet2014@gmail.com', 'Julie', '1923-11-05', '3923-11-10', 12, 2),
(23, 'jberthet2014@gmail.com', 'Julie', '2023-11-05', '2023-11-10', 12, 2),
(24, 'jberthet2014@gmail.com', 'Julie', '2023-11-05', '2023-11-10', 12, 2),
(25, 'jberthet2014@gmail.com', 'Julie', '2023-11-05', '2023-11-10', 12, 2),
(26, 'jberthet2014@gmail.com', 'Julie', '2023-11-05', '2023-11-10', 12, 2),
(27, 'null', 'null', '2023-11-05', '2023-11-10', 12, 0),
(28, 'null', 'null', '2023-11-05', '2023-11-10', 12, 0),
(29, 'jdejarmy@gmail.com', 'Jade', '2023-11-05', '2023-11-10', 12, 0),
(30, 'null', 'null', '2023-11-05', '2023-11-10', 12, 0),
(31, 'jdejarmy@gmail.com', 'Jade', '2023-11-05', '2023-11-10', 12, 0),
(32, 'null', 'null', '2023-11-05', '2023-11-10', 12, 0),
(33, 'jdejarmy@gmail.com', 'null', '2023-11-05', '2023-11-10', 12, 17),
(34, 'null', 'null', '2023-11-05', '2023-11-10', 8, 0),
(35, 'jdejarmy@gmail.com', 'null', '2023-11-05', '2023-11-10', 8, 17),
(36, 'null', 'null', '2023-11-05', '2023-11-10', 11, 0),
(37, 'null', 'null', '2023-11-05', '2023-11-10', 11, 0),
(38, 'jdejarmy@gmail.com', 'Jade', '2023-11-05', '2023-11-10', 11, 17);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
