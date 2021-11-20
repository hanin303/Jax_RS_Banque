-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 20 nov. 2021 à 15:12
-- Version du serveur :  5.7.31
-- Version de PHP : 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `banque`
--

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `type_cpte` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  `numcompte` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datecreation` datetime(6) DEFAULT NULL,
  `solde` double NOT NULL,
  `decouvert` double DEFAULT NULL,
  `taux` double DEFAULT NULL,
  `code_client` bigint(20) DEFAULT NULL,
  `code` bigint(20) NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`numcompte`),
  KEY `FK5sro9uaorpt8u6ho6nbwuauob` (`code_client`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`type_cpte`, `numcompte`, `datecreation`, `solde`, `decouvert`, `taux`, `code_client`, `code`, `date`) VALUES
('CC', 'cpt1', '2021-11-20 08:02:05.021000', 6000, 6000, NULL, 1, 0, NULL),
('CE', 'cpt2', '2021-11-20 08:02:05.177000', 7000, NULL, 5.5, 2, 0, NULL);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `FK5sro9uaorpt8u6ho6nbwuauob` FOREIGN KEY (`code_client`) REFERENCES `clients` (`code_client`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
