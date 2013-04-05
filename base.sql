-- phpMyAdmin SQL Dump
-- version 3.4.9
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le : Ven 05 Avril 2013 à 21:19
-- Version du serveur: 5.5.20
-- Version de PHP: 5.3.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `base`
--

-- --------------------------------------------------------

--
-- Structure de la table `group`
--

CREATE TABLE IF NOT EXISTS `group` (
  `idGroup` int(10) unsigned NOT NULL,
  `nameGroup` varchar(45) NOT NULL,
  `dateGroup` date DEFAULT NULL,
  PRIMARY KEY (`idGroup`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `group`
--

INSERT INTO `group` (`idGroup`, `nameGroup`, `dateGroup`) VALUES
(1, 'mahdi', NULL),
(2, '3Cinfo2', NULL),
(4, '3Cinfo2', NULL),
(5, '3Cinfo2', '2013-04-05');

-- --------------------------------------------------------

--
-- Structure de la table `rambling`
--

CREATE TABLE IF NOT EXISTS `rambling` (
  `idRambling` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `destination` varchar(255) NOT NULL,
  `fkUser` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idRambling`),
  KEY `fkUser` (`fkUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstNameUser` varchar(45) NOT NULL,
  `lastNameUser` varchar(45) NOT NULL,
  `fkGroup` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  KEY `FK_group` (`fkGroup`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`idUser`, `firstNameUser`, `lastNameUser`, `fkGroup`) VALUES
(2, 'foulen', 'ben foulen', 4),
(3, 'mahdi', 'cherif', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `vote`
--

CREATE TABLE IF NOT EXISTS `vote` (
  `idVote` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `state` varchar(45) NOT NULL,
  `idUser` int(10) unsigned NOT NULL,
  `idRambling` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idVote`),
  KEY `FK_vote_1` (`idUser`),
  KEY `FK_vote_2` (`idRambling`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `rambling`
--
ALTER TABLE `rambling`
  ADD CONSTRAINT `fkUser` FOREIGN KEY (`fkUser`) REFERENCES `user` (`idUser`);

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_group` FOREIGN KEY (`fkGroup`) REFERENCES `group` (`idGroup`);

--
-- Contraintes pour la table `vote`
--
ALTER TABLE `vote`
  ADD CONSTRAINT `FK_vote_2` FOREIGN KEY (`idRambling`) REFERENCES `rambling` (`idRambling`),
  ADD CONSTRAINT `FK_vote_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
