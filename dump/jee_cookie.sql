-- phpMyAdmin SQL Dump
-- version 3.5.8.1deb1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mar 20 Mai 2014 à 18:52
-- Version du serveur: 5.5.34-0ubuntu0.13.04.1
-- Version de PHP: 5.4.9-4ubuntu2.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `jee_cookie`
--

-- --------------------------------------------------------

--
-- Structure de la table `Recipe`
--

CREATE TABLE IF NOT EXISTS `Recipe` (
  `title` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `expertise` int(11) DEFAULT NULL,
  `nbpeople` int(11) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Recipe`
--

INSERT INTO `Recipe` (`title`, `description`, `expertise`, `nbpeople`, `duration`, `type`) VALUES
('Patates', 'Plein de patates au four', 1, 4, 15, 'Patateries'),
('Poisson à la meringue', 'Rien de particulier', 3, 5, 53, 'poissonnerie'),
('Purée', 'Mousline y''a que ca de vrai', 1, 4, 15, 'Patateries'),
('Poisson à la crême', 'Miam', 3, 5, 53, 'poissonnerie'),
('Tomates brulées', 'Le feu ca brûle', 1, 2, 25, 'Dessert'),
('Dinde aux marrons', 'C''est Nauelle', 3, 5, 73, 'gourmandise'),
('Patates encore', 'Plein de patates au feu de bois', 1, 5, 35, 'Patateries'),
('Poisson aux marrons', 'Rien de particulier', 3, 5, 53, 'gourmandise'),
('Roquefort', 'Plus fort que ta mère', 1, 4, 12, 'gourmandise'),
('Poisson au thon ', 'Rien de particulier', 3, 5, 53, 'poissonnerie'),
('Tarte à Tain', 'Plein de patates dans cette tarte', 1, 4, 15, 'Patateries'),
('Tarte à la meringue', 'Rien de particulier mais pas de poisson ici', 3, 15, 53, 'tarte'),
('Tarte aux patates', 'Plein de patates au barbecue', 1, 2, 15, 'Patateries'),
('Une recette originale', 'Rien de bien original', 3, 5, 53, 'osef'),
('Patates', 'Plein de patates au charbon', 1, 2, 85, 'Patateries'),
('Poisson à la sauce blanche', 'Sauce épicée', 3, 5, 23, 'poissonnerie'),
('Patates', 'Plein de patates au four', 1, 4, 15, 'Patateries'),
('Poisson à la meringue', 'Rien de particulier', 3, 5, 53, 'poissonnerie');

-- --------------------------------------------------------

--
-- Structure de la table `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `firstname` varchar(30) DEFAULT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `login` varchar(30) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `User`
--

INSERT INTO `User` (`firstname`, `lastname`, `age`, `login`, `pwd`, `email`) VALUES
('baptiste', 'bouchereau', 10, 'babou', 'babou', 'babou@gmail.com'),
('pierre-jean', 'leger', 20, 'pjle', 'pjle', 'pjle@gmail.com');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
