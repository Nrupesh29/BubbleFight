CREATE TABLE `Match` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `P1Id` int(8) DEFAULT NULL,
  `P2Id` int(8) DEFAULT NULL,
  `TournamentId` int(8) DEFAULT NULL,
  `LevelId` int(8) DEFAULT NULL,
  `WinnerId` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
