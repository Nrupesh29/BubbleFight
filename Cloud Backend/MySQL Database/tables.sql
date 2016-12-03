
--
-- Table structure for table `level`
--

DROP TABLE IF EXISTS `level`;

CREATE TABLE `level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


--
-- Table structure for table `matches`
--

DROP TABLE IF EXISTS `matches`;

CREATE TABLE `matches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `player_one_id` int(11) DEFAULT NULL,
  `player_two_id` int(11) DEFAULT NULL,
  `tournament_id` int(11) DEFAULT NULL,
  `level_id` int(11) DEFAULT NULL,
  `winner_id` int(11) DEFAULT NULL,
  `matchdate` datetime DEFAULT NULL,
  `score` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;

CREATE TABLE `player` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


--
-- Table structure for table `tournament`
--

DROP TABLE IF EXISTS `tournament`;

CREATE TABLE `tournament` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL,
  `maxplayers` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
