CREATE TABLE `Tournament` (
  `TournamentId` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) NOT NULL,
  `Maxplayer` int(8) DEFAULT NULL,
  PRIMARY KEY (`TournamentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
